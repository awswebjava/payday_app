package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recuperaparametrosdeconcepto extends GXProcedure
{
   public recuperaparametrosdeconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recuperaparametrosdeconcepto.class ), "" );
   }

   public recuperaparametrosdeconcepto( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           String aP2 ,
                                           GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> aP3 ,
                                           int[] aP4 ,
                                           String[] aP5 ,
                                           String[] aP6 ,
                                           String[] aP7 ,
                                           String[] aP8 ,
                                           boolean[] aP9 ,
                                           String[] aP10 ,
                                           String[] aP11 ,
                                           String[] aP12 )
   {
      recuperaparametrosdeconcepto.this.aP13 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> aP3 ,
                        int[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        boolean[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        java.math.BigDecimal[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> aP3 ,
                             int[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             java.math.BigDecimal[] aP13 )
   {
      recuperaparametrosdeconcepto.this.AV22CliCod = aP0;
      recuperaparametrosdeconcepto.this.AV14PaiCod = aP1;
      recuperaparametrosdeconcepto.this.AV12idOperando = aP2;
      recuperaparametrosdeconcepto.this.AV8cal_par_valores = aP3;
      recuperaparametrosdeconcepto.this.aP4 = aP4;
      recuperaparametrosdeconcepto.this.aP5 = aP5;
      recuperaparametrosdeconcepto.this.aP6 = aP6;
      recuperaparametrosdeconcepto.this.aP7 = aP7;
      recuperaparametrosdeconcepto.this.aP8 = aP8;
      recuperaparametrosdeconcepto.this.aP9 = aP9;
      recuperaparametrosdeconcepto.this.aP10 = aP10;
      recuperaparametrosdeconcepto.this.aP11 = aP11;
      recuperaparametrosdeconcepto.this.aP12 = aP12;
      recuperaparametrosdeconcepto.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&cal_par_valores ", "")+GXutil.trim( GXutil.str( AV8cal_par_valores.size(), 9, 0))) ;
      AV26GXV1 = 1 ;
      while ( AV26GXV1 <= AV8cal_par_valores.size() )
      {
         AV13itemCalParVal = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV8cal_par_valores.elementAt(-1+AV26GXV1));
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&itemCalParVal.CalParId \"", "")+AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()+httpContext.getMessage( "\" &itemCalParVal.value ", "")+AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value()+httpContext.getMessage( " parametroCalculo.periodo \"", "")+"Periodo"+"\"") ;
         if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "Categoria") == 0 )
         {
            AV20CatCodigo = AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value() ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "SueldoBasico") == 0 )
         {
            AV21SueldoBasico = CommonUtil.decimalVal( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value(), ".") ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "Concepto") == 0 )
         {
            AV18ConCodigo = AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value() ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "agarra concepto ", "")+AV18ConCodigo) ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "TipoDeConcepto") == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "enta tipoconcepto", "")) ;
            GXt_char1 = AV19TipoConCod ;
            GXv_char2[0] = GXt_char1 ;
            new web.getipocondepalabra(remoteHandle, context).execute( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value(), GXv_char2) ;
            recuperaparametrosdeconcepto.this.GXt_char1 = GXv_char2[0] ;
            AV19TipoConCod = GXt_char1 ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "Periodo") == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( httpContext.getMessage( "entra en case periodo", ""), "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( httpContext.getMessage( "&itemCalParVal.value ", "")+AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value(), "") ;
            if ( CommonUtil.decimalVal( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value(), ".").doubleValue() > 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( httpContext.getMessage( "es numero", ""), "") ;
               AV15periodoNum6 = (int)(GXutil.lval( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value())) ;
               new web.msgdebug_prod(remoteHandle, context).execute( httpContext.getMessage( "queda ", "")+GXutil.trim( GXutil.str( AV15periodoNum6, 6, 0)), "") ;
            }
            else
            {
               AV17CriterioBusqueda = GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value()) ;
            }
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "Devolver") == 0 )
         {
            AV10Devolver = AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value() ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "TipoLiq") == 0 )
         {
            GXv_char2[0] = AV16TLiqCod ;
            GXv_boolean3[0] = false ;
            new web.gettipoliqdepalabra(remoteHandle, context).execute( AV22CliCod, AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value(), GXv_char2, GXv_boolean3) ;
            recuperaparametrosdeconcepto.this.AV16TLiqCod = GXv_char2[0] ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()), "Calculo") == 0 )
         {
            AV9Calculo = AV13itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value() ;
         }
         AV26GXV1 = (int)(AV26GXV1+1) ;
      }
      if ( ! (GXutil.strcmp("", AV17CriterioBusqueda)==0) || ! (0==AV15periodoNum6) )
      {
         AV11esLiqAnt = true ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&cal_par_valores.Count: ", "")+GXutil.trim( GXutil.str( AV8cal_par_valores.size(), 9, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CatCodigo: ", "")+GXutil.trim( AV20CatCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&SueldoBasico: ", "")+GXutil.trim( GXutil.str( AV21SueldoBasico, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&ConCodigo: ", "")+GXutil.trim( AV18ConCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&TipoConCod: ", "")+GXutil.trim( AV19TipoConCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CriterioBusqueda: ", "")+GXutil.trim( AV17CriterioBusqueda)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&Devolver: ", "")+GXutil.trim( AV10Devolver)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&TLiqCod: ", "")+GXutil.trim( AV16TLiqCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&Calculo: ", "")+GXutil.trim( AV9Calculo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&periodoNum6: ", "")+GXutil.trim( GXutil.str( AV15periodoNum6, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&esLiqAnt: ", "")+GXutil.trim( GXutil.booltostr( AV11esLiqAnt))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = recuperaparametrosdeconcepto.this.AV15periodoNum6;
      this.aP5[0] = recuperaparametrosdeconcepto.this.AV17CriterioBusqueda;
      this.aP6[0] = recuperaparametrosdeconcepto.this.AV10Devolver;
      this.aP7[0] = recuperaparametrosdeconcepto.this.AV9Calculo;
      this.aP8[0] = recuperaparametrosdeconcepto.this.AV16TLiqCod;
      this.aP9[0] = recuperaparametrosdeconcepto.this.AV11esLiqAnt;
      this.aP10[0] = recuperaparametrosdeconcepto.this.AV18ConCodigo;
      this.aP11[0] = recuperaparametrosdeconcepto.this.AV19TipoConCod;
      this.aP12[0] = recuperaparametrosdeconcepto.this.AV20CatCodigo;
      this.aP13[0] = recuperaparametrosdeconcepto.this.AV21SueldoBasico;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17CriterioBusqueda = "" ;
      AV10Devolver = "" ;
      AV9Calculo = "" ;
      AV16TLiqCod = "" ;
      AV18ConCodigo = "" ;
      AV19TipoConCod = "" ;
      AV20CatCodigo = "" ;
      AV21SueldoBasico = DecimalUtil.ZERO ;
      AV25Pgmname = "" ;
      AV13itemCalParVal = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV25Pgmname = "recuperaParametrosDeConcepto" ;
      /* GeneXus formulas. */
      AV25Pgmname = "recuperaParametrosDeConcepto" ;
      Gx_err = (short)(0) ;
   }

   private short AV14PaiCod ;
   private short Gx_err ;
   private int AV22CliCod ;
   private int AV15periodoNum6 ;
   private int AV26GXV1 ;
   private java.math.BigDecimal AV21SueldoBasico ;
   private String AV12idOperando ;
   private String AV17CriterioBusqueda ;
   private String AV10Devolver ;
   private String AV9Calculo ;
   private String AV16TLiqCod ;
   private String AV18ConCodigo ;
   private String AV19TipoConCod ;
   private String AV20CatCodigo ;
   private String AV25Pgmname ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV11esLiqAnt ;
   private boolean GXv_boolean3[] ;
   private java.math.BigDecimal[] aP13 ;
   private int[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private boolean[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV8cal_par_valores ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV13itemCalParVal ;
}

