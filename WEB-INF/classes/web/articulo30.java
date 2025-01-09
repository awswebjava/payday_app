package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class articulo30 extends GXProcedure
{
   public articulo30( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articulo30.class ), "" );
   }

   public articulo30( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             String[] aP5 )
   {
      articulo30.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      articulo30.this.AV9CliCod = aP0;
      articulo30.this.AV8idOperando = aP1;
      articulo30.this.AV10LiqPeriodo = aP2;
      articulo30.this.AV11ProcesoLiquidacion = aP3;
      articulo30.this.aP4 = aP4;
      articulo30.this.aP5 = aP5;
      articulo30.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8idOperando, "[mni_zona]") == 0 )
      {
         AV16constantes_default = "[mni]" ;
         GXv_char1[0] = AV12OpeCliValor ;
         GXv_char2[0] = AV13auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV16constantes_default, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char1, GXv_char2) ;
         articulo30.this.AV12OpeCliValor = GXv_char1[0] ;
         articulo30.this.AV13auxError = GXv_char2[0] ;
      }
      else if ( GXutil.strcmp(AV8idOperando, "[ded_hijo_zona]") == 0 )
      {
         AV16constantes_default = "[ded_hijo]" ;
         GXv_char2[0] = AV12OpeCliValor ;
         GXv_char1[0] = AV13auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV16constantes_default, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char2, GXv_char1) ;
         articulo30.this.AV12OpeCliValor = GXv_char2[0] ;
         articulo30.this.AV13auxError = GXv_char1[0] ;
      }
      else if ( GXutil.strcmp(AV8idOperando, "[ded_hijo_incap_zona]") == 0 )
      {
         AV16constantes_default = "[ded_hijo_incap]" ;
         GXv_char2[0] = AV12OpeCliValor ;
         GXv_char1[0] = AV13auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV16constantes_default, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char2, GXv_char1) ;
         articulo30.this.AV12OpeCliValor = GXv_char2[0] ;
         articulo30.this.AV13auxError = GXv_char1[0] ;
      }
      else if ( GXutil.strcmp(AV8idOperando, "[ded_cony_zona]") == 0 )
      {
         AV16constantes_default = "[ded_cony]" ;
         GXv_char2[0] = AV12OpeCliValor ;
         GXv_char1[0] = AV13auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV16constantes_default, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char2, GXv_char1) ;
         articulo30.this.AV12OpeCliValor = GXv_char2[0] ;
         articulo30.this.AV13auxError = GXv_char1[0] ;
      }
      else if ( GXutil.strcmp(AV8idOperando, "[ded_especial_zona]") == 0 )
      {
         AV16constantes_default = "[ded_especial]" ;
         GXv_char2[0] = AV12OpeCliValor ;
         GXv_char1[0] = AV13auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV16constantes_default, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char2, GXv_char1) ;
         articulo30.this.AV12OpeCliValor = GXv_char2[0] ;
         articulo30.this.AV13auxError = GXv_char1[0] ;
      }
      if ( ! (GXutil.strcmp("", AV12OpeCliValor)==0) )
      {
         AV14importes = CommonUtil.decimalVal( AV12OpeCliValor, ".") ;
         AV15variableDescrip = GXutil.trim( httpContext.getMessage( web.gxdomainconstantes_default.getDescription(httpContext,(String)AV16constantes_default), "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = articulo30.this.AV14importes;
      this.aP5[0] = articulo30.this.AV13auxError;
      this.aP6[0] = articulo30.this.AV15variableDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14importes = DecimalUtil.ZERO ;
      AV13auxError = "" ;
      AV15variableDescrip = "" ;
      AV16constantes_default = "" ;
      AV12OpeCliValor = "" ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private java.math.BigDecimal AV14importes ;
   private String AV8idOperando ;
   private String AV11ProcesoLiquidacion ;
   private String AV16constantes_default ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private java.util.Date AV10LiqPeriodo ;
   private String AV12OpeCliValor ;
   private String AV13auxError ;
   private String AV15variableDescrip ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP4 ;
   private String[] aP5 ;
}

