package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaitipotraold extends GXProcedure
{
   public getpaitipotraold( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaitipotraold.class ), "" );
   }

   public getpaitipotraold( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 ,
                                           String aP1 ,
                                           java.math.BigDecimal[] aP2 ,
                                           java.math.BigDecimal[] aP3 ,
                                           java.math.BigDecimal[] aP4 ,
                                           java.math.BigDecimal[] aP5 ,
                                           java.math.BigDecimal[] aP6 ,
                                           java.math.BigDecimal[] aP7 ,
                                           java.math.BigDecimal[] aP8 )
   {
      getpaitipotraold.this.aP9 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        java.math.BigDecimal[] aP2 ,
                        java.math.BigDecimal[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             java.math.BigDecimal[] aP2 ,
                             java.math.BigDecimal[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 )
   {
      getpaitipotraold.this.AV9PaiCod = aP0;
      getpaitipotraold.this.AV8PaiTipoTraId = aP1;
      getpaitipotraold.this.aP2 = aP2;
      getpaitipotraold.this.aP3 = aP3;
      getpaitipotraold.this.aP4 = aP4;
      getpaitipotraold.this.aP5 = aP5;
      getpaitipotraold.this.aP6 = aP6;
      getpaitipotraold.this.aP7 = aP7;
      getpaitipotraold.this.aP8 = aP8;
      getpaitipotraold.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV9PaiCod, 4, 0))+httpContext.getMessage( " &PaiTipoTraId ", "")+GXutil.trim( AV8PaiTipoTraId)) ;
      AV21GXLvl2 = (byte)(0) ;
      /* Using cursor P01Y42 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), AV8PaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P01Y42_A1294PaiTipoTraId[0] ;
         A46PaiCod = P01Y42_A46PaiCod[0] ;
         A2070PaiTipoTraOld = P01Y42_A2070PaiTipoTraOld[0] ;
         AV21GXLvl2 = (byte)(1) ;
         GXv_decimal1[0] = AV10PaiTipoHsDia ;
         GXv_decimal2[0] = AV11PaiTipoHsSem ;
         GXv_decimal3[0] = AV12PaiTipoTarifaXLim ;
         GXv_decimal4[0] = AV13PaiTipoTarifaRec ;
         GXv_decimal5[0] = AV14PaiTipoHsMaxDia ;
         GXv_decimal6[0] = AV15PaiTipoHsMaxSem ;
         GXv_decimal7[0] = AV16PaiTipoHsMaxMes ;
         GXv_decimal8[0] = AV17PaiTipoHsMaxAnu ;
         new web.getpaitipotraoldcampos(remoteHandle, context).execute( A2070PaiTipoTraOld, GXv_decimal1, GXv_decimal2, GXv_decimal3, GXv_decimal4, GXv_decimal5, GXv_decimal6, GXv_decimal7, GXv_decimal8) ;
         getpaitipotraold.this.AV10PaiTipoHsDia = GXv_decimal1[0] ;
         getpaitipotraold.this.AV11PaiTipoHsSem = GXv_decimal2[0] ;
         getpaitipotraold.this.AV12PaiTipoTarifaXLim = GXv_decimal3[0] ;
         getpaitipotraold.this.AV13PaiTipoTarifaRec = GXv_decimal4[0] ;
         getpaitipotraold.this.AV14PaiTipoHsMaxDia = GXv_decimal5[0] ;
         getpaitipotraold.this.AV15PaiTipoHsMaxSem = GXv_decimal6[0] ;
         getpaitipotraold.this.AV16PaiTipoHsMaxMes = GXv_decimal7[0] ;
         getpaitipotraold.this.AV17PaiTipoHsMaxAnu = GXv_decimal8[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "PaiTipoTraOld ", "")+A2070PaiTipoTraOld) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV21GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getpaitipotraold.this.AV10PaiTipoHsDia;
      this.aP3[0] = getpaitipotraold.this.AV11PaiTipoHsSem;
      this.aP4[0] = getpaitipotraold.this.AV12PaiTipoTarifaXLim;
      this.aP5[0] = getpaitipotraold.this.AV13PaiTipoTarifaRec;
      this.aP6[0] = getpaitipotraold.this.AV14PaiTipoHsMaxDia;
      this.aP7[0] = getpaitipotraold.this.AV15PaiTipoHsMaxSem;
      this.aP8[0] = getpaitipotraold.this.AV16PaiTipoHsMaxMes;
      this.aP9[0] = getpaitipotraold.this.AV17PaiTipoHsMaxAnu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PaiTipoHsDia = DecimalUtil.ZERO ;
      AV11PaiTipoHsSem = DecimalUtil.ZERO ;
      AV12PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      AV13PaiTipoTarifaRec = DecimalUtil.ZERO ;
      AV14PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      AV15PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      AV16PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      AV17PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      P01Y42_A1294PaiTipoTraId = new String[] {""} ;
      P01Y42_A46PaiCod = new short[1] ;
      P01Y42_A2070PaiTipoTraOld = new String[] {""} ;
      A1294PaiTipoTraId = "" ;
      A2070PaiTipoTraOld = "" ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaitipotraold__default(),
         new Object[] {
             new Object[] {
            P01Y42_A1294PaiTipoTraId, P01Y42_A46PaiCod, P01Y42_A2070PaiTipoTraOld
            }
         }
      );
      AV20Pgmname = "getPaiTipoTraOld" ;
      /* GeneXus formulas. */
      AV20Pgmname = "getPaiTipoTraOld" ;
      Gx_err = (short)(0) ;
   }

   private byte AV21GXLvl2 ;
   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV10PaiTipoHsDia ;
   private java.math.BigDecimal AV11PaiTipoHsSem ;
   private java.math.BigDecimal AV12PaiTipoTarifaXLim ;
   private java.math.BigDecimal AV13PaiTipoTarifaRec ;
   private java.math.BigDecimal AV14PaiTipoHsMaxDia ;
   private java.math.BigDecimal AV15PaiTipoHsMaxSem ;
   private java.math.BigDecimal AV16PaiTipoHsMaxMes ;
   private java.math.BigDecimal AV17PaiTipoHsMaxAnu ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV8PaiTipoTraId ;
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String A2070PaiTipoTraOld ;
   private java.math.BigDecimal[] aP9 ;
   private java.math.BigDecimal[] aP2 ;
   private java.math.BigDecimal[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P01Y42_A1294PaiTipoTraId ;
   private short[] P01Y42_A46PaiCod ;
   private String[] P01Y42_A2070PaiTipoTraOld ;
}

final  class getpaitipotraold__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Y42", "SELECT PaiTipoTraId, PaiCod, PaiTipoTraOld FROM PaisTipoTrabajo WHERE PaiCod = ? and PaiTipoTraId = ( ?) ORDER BY PaiCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

