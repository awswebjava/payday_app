package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqlegsumarcontribuciones extends GXProcedure
{
   public liqlegsumarcontribuciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqlegsumarcontribuciones.class ), "" );
   }

   public liqlegsumarcontribuciones( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 )
   {
      liqlegsumarcontribuciones.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      liqlegsumarcontribuciones.this.AV13CliCod = aP0;
      liqlegsumarcontribuciones.this.AV12EmpCod = aP1;
      liqlegsumarcontribuciones.this.AV11LiqNro = aP2;
      liqlegsumarcontribuciones.this.AV10LegNumero = aP3;
      liqlegsumarcontribuciones.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9DSubTipoConCod1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipocontribucion(remoteHandle, context).execute( GXv_char2) ;
      liqlegsumarcontribuciones.this.GXt_char1 = GXv_char2[0] ;
      AV9DSubTipoConCod1 = GXt_char1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "CliCod: ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "EmpCod: ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "LiqNro: ", "")+GXutil.trim( GXutil.str( AV11LiqNro, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "LegNumero: ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "DSubTipoConCod1: ", "")+GXutil.trim( AV9DSubTipoConCod1)) ;
      AV17GXLvl11 = (byte)(0) ;
      /* Using cursor P01MG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero), AV9DSubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A732DSubTipoConCod2 = P01MG2_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P01MG2_n732DSubTipoConCod2[0] ;
         A468DSubTipoConCod1 = P01MG2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01MG2_n468DSubTipoConCod1[0] ;
         A464DTipoConCod = P01MG2_A464DTipoConCod[0] ;
         A6LegNumero = P01MG2_A6LegNumero[0] ;
         A31LiqNro = P01MG2_A31LiqNro[0] ;
         A1EmpCod = P01MG2_A1EmpCod[0] ;
         A3CliCod = P01MG2_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01MG2_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P01MG2_A81LiqDSecuencial[0] ;
         AV17GXLvl11 = (byte)(1) ;
         AV8LiqLegImpContr = AV8LiqLegImpContr.add(A764LiqDImpReCalcu) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "suma ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV17GXLvl11 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV16Pgmname, httpContext.getMessage( "none1!!", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = liqlegsumarcontribuciones.this.AV8LiqLegImpContr;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LiqLegImpContr = DecimalUtil.ZERO ;
      AV9DSubTipoConCod1 = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      P01MG2_A732DSubTipoConCod2 = new String[] {""} ;
      P01MG2_n732DSubTipoConCod2 = new boolean[] {false} ;
      P01MG2_A468DSubTipoConCod1 = new String[] {""} ;
      P01MG2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01MG2_A464DTipoConCod = new String[] {""} ;
      P01MG2_A6LegNumero = new int[1] ;
      P01MG2_A31LiqNro = new int[1] ;
      P01MG2_A1EmpCod = new short[1] ;
      P01MG2_A3CliCod = new int[1] ;
      P01MG2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01MG2_A81LiqDSecuencial = new int[1] ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      A464DTipoConCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqlegsumarcontribuciones__default(),
         new Object[] {
             new Object[] {
            P01MG2_A732DSubTipoConCod2, P01MG2_n732DSubTipoConCod2, P01MG2_A468DSubTipoConCod1, P01MG2_n468DSubTipoConCod1, P01MG2_A464DTipoConCod, P01MG2_A6LegNumero, P01MG2_A31LiqNro, P01MG2_A1EmpCod, P01MG2_A3CliCod, P01MG2_A764LiqDImpReCalcu,
            P01MG2_A81LiqDSecuencial
            }
         }
      );
      AV16Pgmname = "liqLegSumarContribuciones" ;
      /* GeneXus formulas. */
      AV16Pgmname = "liqLegSumarContribuciones" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl11 ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV8LiqLegImpContr ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV9DSubTipoConCod1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private String A464DTipoConCod ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MG2_A732DSubTipoConCod2 ;
   private boolean[] P01MG2_n732DSubTipoConCod2 ;
   private String[] P01MG2_A468DSubTipoConCod1 ;
   private boolean[] P01MG2_n468DSubTipoConCod1 ;
   private String[] P01MG2_A464DTipoConCod ;
   private int[] P01MG2_A6LegNumero ;
   private int[] P01MG2_A31LiqNro ;
   private short[] P01MG2_A1EmpCod ;
   private int[] P01MG2_A3CliCod ;
   private java.math.BigDecimal[] P01MG2_A764LiqDImpReCalcu ;
   private int[] P01MG2_A81LiqDSecuencial ;
}

final  class liqlegsumarcontribuciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MG2", "SELECT DSubTipoConCod2, DSubTipoConCod1, DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DSubTipoConCod1 = ( ?)) AND ((char_length(trim(trailing ' ' from DSubTipoConCod2))=0)) AND (DTipoConCod = ( 'CAL_ARG')) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DSubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[10])[0] = rslt.getInt(9);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

