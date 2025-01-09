package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayferiadotrabajado extends GXProcedure
{
   public hayferiadotrabajado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayferiadotrabajado.class ), "" );
   }

   public hayferiadotrabajado( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              java.util.Date aP4 )
   {
      hayferiadotrabajado.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             boolean[] aP5 )
   {
      hayferiadotrabajado.this.AV9CliCod = aP0;
      hayferiadotrabajado.this.AV10EmpCod = aP1;
      hayferiadotrabajado.this.AV11LegNumero = aP2;
      hayferiadotrabajado.this.AV32ini_periodo = aP3;
      hayferiadotrabajado.this.AV13fin_periodo = aP4;
      hayferiadotrabajado.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&ini_periodo ", "")+GXutil.trim( localUtil.dtoc( AV32ini_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&ini_periodo ", "")+GXutil.trim( localUtil.dtoc( AV32ini_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &fin_periodo ", "")+GXutil.trim( localUtil.dtoc( AV13fin_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
      GXt_char1 = AV30ferTrabConCodigo ;
      GXt_char2 = AV30ferTrabConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.feriadostrabajados_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      hayferiadotrabajado.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      hayferiadotrabajado.this.GXt_char1 = GXv_char4[0] ;
      AV30ferTrabConCodigo = GXt_char1 ;
      AV36GXLvl6 = (byte)(0) ;
      /* Using cursor P01C72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV30ferTrabConCodigo, AV32ini_periodo, AV13fin_periodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01C72_A26ConCodigo[0] ;
         A112AgeFecHas = P01C72_A112AgeFecHas[0] ;
         n112AgeFecHas = P01C72_n112AgeFecHas[0] ;
         A111AgeFecDes = P01C72_A111AgeFecDes[0] ;
         n111AgeFecDes = P01C72_n111AgeFecDes[0] ;
         A6LegNumero = P01C72_A6LegNumero[0] ;
         A1EmpCod = P01C72_A1EmpCod[0] ;
         A3CliCod = P01C72_A3CliCod[0] ;
         A25AgeOrden = P01C72_A25AgeOrden[0] ;
         AV36GXLvl6 = (byte)(1) ;
         AV31hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl6 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = hayferiadotrabajado.this.AV31hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV35Pgmname = "" ;
      AV30ferTrabConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P01C72_A26ConCodigo = new String[] {""} ;
      P01C72_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P01C72_n112AgeFecHas = new boolean[] {false} ;
      P01C72_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P01C72_n111AgeFecDes = new boolean[] {false} ;
      P01C72_A6LegNumero = new int[1] ;
      P01C72_A1EmpCod = new short[1] ;
      P01C72_A3CliCod = new int[1] ;
      P01C72_A25AgeOrden = new short[1] ;
      A26ConCodigo = "" ;
      A112AgeFecHas = GXutil.nullDate() ;
      A111AgeFecDes = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayferiadotrabajado__default(),
         new Object[] {
             new Object[] {
            P01C72_A26ConCodigo, P01C72_A112AgeFecHas, P01C72_n112AgeFecHas, P01C72_A111AgeFecDes, P01C72_n111AgeFecDes, P01C72_A6LegNumero, P01C72_A1EmpCod, P01C72_A3CliCod, P01C72_A25AgeOrden
            }
         }
      );
      AV35Pgmname = "hayFeriadoTrabajado" ;
      /* GeneXus formulas. */
      AV35Pgmname = "hayFeriadoTrabajado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV36GXLvl6 ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV35Pgmname ;
   private String AV30ferTrabConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private java.util.Date AV32ini_periodo ;
   private java.util.Date AV13fin_periodo ;
   private java.util.Date A112AgeFecHas ;
   private java.util.Date A111AgeFecDes ;
   private boolean AV31hay ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01C72_A26ConCodigo ;
   private java.util.Date[] P01C72_A112AgeFecHas ;
   private boolean[] P01C72_n112AgeFecHas ;
   private java.util.Date[] P01C72_A111AgeFecDes ;
   private boolean[] P01C72_n111AgeFecDes ;
   private int[] P01C72_A6LegNumero ;
   private short[] P01C72_A1EmpCod ;
   private int[] P01C72_A3CliCod ;
   private short[] P01C72_A25AgeOrden ;
}

final  class hayferiadotrabajado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01C72", "SELECT ConCodigo, AgeFecHas, AgeFecDes, LegNumero, EmpCod, CliCod, AgeOrden FROM AgendaNovedades WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and ConCodigo = ( ?)) AND (AgeFecHas >= ?) AND (AgeFecDes <= ?) ORDER BY CliCod, EmpCod, LegNumero, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
      }
   }

}

