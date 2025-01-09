package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaitipotraoldcampos extends GXProcedure
{
   public getpaitipotraoldcampos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaitipotraoldcampos.class ), "" );
   }

   public getpaitipotraoldcampos( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 ,
                                           java.math.BigDecimal[] aP1 ,
                                           java.math.BigDecimal[] aP2 ,
                                           java.math.BigDecimal[] aP3 ,
                                           java.math.BigDecimal[] aP4 ,
                                           java.math.BigDecimal[] aP5 ,
                                           java.math.BigDecimal[] aP6 ,
                                           java.math.BigDecimal[] aP7 )
   {
      getpaitipotraoldcampos.this.aP8 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal[] aP1 ,
                        java.math.BigDecimal[] aP2 ,
                        java.math.BigDecimal[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal[] aP1 ,
                             java.math.BigDecimal[] aP2 ,
                             java.math.BigDecimal[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 )
   {
      getpaitipotraoldcampos.this.AV17PaiTipoTraOld = aP0;
      getpaitipotraoldcampos.this.aP1 = aP1;
      getpaitipotraoldcampos.this.aP2 = aP2;
      getpaitipotraoldcampos.this.aP3 = aP3;
      getpaitipotraoldcampos.this.aP4 = aP4;
      getpaitipotraoldcampos.this.aP5 = aP5;
      getpaitipotraoldcampos.this.aP6 = aP6;
      getpaitipotraoldcampos.this.aP7 = aP7;
      getpaitipotraoldcampos.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8PaisTipoTrabajo_old.fromJSonString(GXutil.trim( AV17PaiTipoTraOld), null);
      AV9PaiTipoHsDia = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia() ;
      AV10PaiTipoHsSem = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipohssem() ;
      AV11PaiTipoTarifaXLim = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim() ;
      AV12PaiTipoTarifaRec = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec() ;
      AV13PaiTipoHsMaxDia = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia() ;
      AV14PaiTipoHsMaxSem = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem() ;
      AV15PaiTipoHsMaxMes = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes() ;
      AV16PaiTipoHsMaxAnu = AV8PaisTipoTrabajo_old.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu() ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaitipotraoldcampos.this.AV9PaiTipoHsDia;
      this.aP2[0] = getpaitipotraoldcampos.this.AV10PaiTipoHsSem;
      this.aP3[0] = getpaitipotraoldcampos.this.AV11PaiTipoTarifaXLim;
      this.aP4[0] = getpaitipotraoldcampos.this.AV12PaiTipoTarifaRec;
      this.aP5[0] = getpaitipotraoldcampos.this.AV13PaiTipoHsMaxDia;
      this.aP6[0] = getpaitipotraoldcampos.this.AV14PaiTipoHsMaxSem;
      this.aP7[0] = getpaitipotraoldcampos.this.AV15PaiTipoHsMaxMes;
      this.aP8[0] = getpaitipotraoldcampos.this.AV16PaiTipoHsMaxAnu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PaiTipoHsDia = DecimalUtil.ZERO ;
      AV10PaiTipoHsSem = DecimalUtil.ZERO ;
      AV11PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      AV12PaiTipoTarifaRec = DecimalUtil.ZERO ;
      AV13PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      AV14PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      AV15PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      AV16PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      AV8PaisTipoTrabajo_old = new web.SdtPaisTipoTrabajo_old(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV9PaiTipoHsDia ;
   private java.math.BigDecimal AV10PaiTipoHsSem ;
   private java.math.BigDecimal AV11PaiTipoTarifaXLim ;
   private java.math.BigDecimal AV12PaiTipoTarifaRec ;
   private java.math.BigDecimal AV13PaiTipoHsMaxDia ;
   private java.math.BigDecimal AV14PaiTipoHsMaxSem ;
   private java.math.BigDecimal AV15PaiTipoHsMaxMes ;
   private java.math.BigDecimal AV16PaiTipoHsMaxAnu ;
   private String AV17PaiTipoTraOld ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP1 ;
   private java.math.BigDecimal[] aP2 ;
   private java.math.BigDecimal[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private web.SdtPaisTipoTrabajo_old AV8PaisTipoTrabajo_old ;
}

