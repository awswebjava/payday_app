package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haylicenciaqueabsorbefer extends GXProcedure
{
   public haylicenciaqueabsorbefer( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haylicenciaqueabsorbefer.class ), "" );
   }

   public haylicenciaqueabsorbefer( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             boolean[] aP5 )
   {
      haylicenciaqueabsorbefer.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        boolean[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             boolean[] aP5 ,
                             String[] aP6 )
   {
      haylicenciaqueabsorbefer.this.AV9CliCod = aP0;
      haylicenciaqueabsorbefer.this.AV10EmpCod = aP1;
      haylicenciaqueabsorbefer.this.AV11LegNumero = aP2;
      haylicenciaqueabsorbefer.this.AV12ini_periodo = aP3;
      haylicenciaqueabsorbefer.this.AV13fin_periodo = aP4;
      haylicenciaqueabsorbefer.this.aP5 = aP5;
      haylicenciaqueabsorbefer.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&ini_periodo ", "")+GXutil.trim( localUtil.dtoc( AV12ini_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &fin_periodo ", "")+GXutil.trim( localUtil.dtoc( AV13fin_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))+httpContext.getMessage( " distinto ", "")+GXutil.trim( GXutil.booltostr( AV18distinto))+httpContext.getMessage( " &LegLicSitCodigo ", "")+GXutil.trim( AV17LegLicSitCodigo)) ;
      AV34GXLvl5 = (byte)(0) ;
      /* Using cursor P01B62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV12ini_periodo, AV13fin_periodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1497LegLicEstado = P01B62_A1497LegLicEstado[0] ;
         A481LegLicenFin = P01B62_A481LegLicenFin[0] ;
         A76LegLicenIni = P01B62_A76LegLicenIni[0] ;
         A6LegNumero = P01B62_A6LegNumero[0] ;
         A1EmpCod = P01B62_A1EmpCod[0] ;
         A3CliCod = P01B62_A3CliCod[0] ;
         A506LegLicSitCodigo = P01B62_A506LegLicSitCodigo[0] ;
         AV34GXLvl5 = (byte)(1) ;
         GXv_boolean1[0] = AV19SitEsLicencia ;
         GXv_boolean2[0] = false ;
         GXv_boolean3[0] = false ;
         GXv_boolean4[0] = false ;
         GXv_boolean5[0] = AV30SitAbsorbeFer ;
         GXv_boolean6[0] = false ;
         GXv_boolean7[0] = false ;
         new web.getsituacionlicenciaprops(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_boolean1, GXv_boolean2, GXv_boolean3, GXv_boolean4, GXv_boolean5, GXv_boolean6, GXv_boolean7) ;
         haylicenciaqueabsorbefer.this.AV19SitEsLicencia = GXv_boolean1[0] ;
         haylicenciaqueabsorbefer.this.AV30SitAbsorbeFer = GXv_boolean5[0] ;
         if ( ( AV19SitEsLicencia ) && ( AV30SitAbsorbeFer ) )
         {
            AV14SitCodigo = A506LegLicSitCodigo ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV34GXLvl5 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = haylicenciaqueabsorbefer.this.AV30SitAbsorbeFer;
      this.aP6[0] = haylicenciaqueabsorbefer.this.AV14SitCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14SitCodigo = "" ;
      AV33Pgmname = "" ;
      AV17LegLicSitCodigo = "" ;
      scmdbuf = "" ;
      P01B62_A1497LegLicEstado = new String[] {""} ;
      P01B62_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01B62_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P01B62_A6LegNumero = new int[1] ;
      P01B62_A1EmpCod = new short[1] ;
      P01B62_A3CliCod = new int[1] ;
      P01B62_A506LegLicSitCodigo = new String[] {""} ;
      A1497LegLicEstado = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haylicenciaqueabsorbefer__default(),
         new Object[] {
             new Object[] {
            P01B62_A1497LegLicEstado, P01B62_A481LegLicenFin, P01B62_A76LegLicenIni, P01B62_A6LegNumero, P01B62_A1EmpCod, P01B62_A3CliCod, P01B62_A506LegLicSitCodigo
            }
         }
      );
      AV33Pgmname = "hayLicenciaQueAbsorbeFer" ;
      /* GeneXus formulas. */
      AV33Pgmname = "hayLicenciaQueAbsorbeFer" ;
      Gx_err = (short)(0) ;
   }

   private byte AV34GXLvl5 ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV14SitCodigo ;
   private String AV33Pgmname ;
   private String AV17LegLicSitCodigo ;
   private String scmdbuf ;
   private String A1497LegLicEstado ;
   private String A506LegLicSitCodigo ;
   private java.util.Date AV12ini_periodo ;
   private java.util.Date AV13fin_periodo ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV30SitAbsorbeFer ;
   private boolean AV18distinto ;
   private boolean AV19SitEsLicencia ;
   private boolean GXv_boolean1[] ;
   private boolean GXv_boolean2[] ;
   private boolean GXv_boolean3[] ;
   private boolean GXv_boolean4[] ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean6[] ;
   private boolean GXv_boolean7[] ;
   private String[] aP6 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01B62_A1497LegLicEstado ;
   private java.util.Date[] P01B62_A481LegLicenFin ;
   private java.util.Date[] P01B62_A76LegLicenIni ;
   private int[] P01B62_A6LegNumero ;
   private short[] P01B62_A1EmpCod ;
   private int[] P01B62_A3CliCod ;
   private String[] P01B62_A506LegLicSitCodigo ;
}

final  class haylicenciaqueabsorbefer__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01B62", "SELECT LegLicEstado, LegLicenFin, LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitCodigo FROM LegajoLicencias WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegLicenFin >= ?) AND (LegLicEstado = ( 'autorizada')) AND (LegLicenIni <= ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 4);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

