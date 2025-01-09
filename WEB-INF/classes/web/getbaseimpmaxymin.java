package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getbaseimpmaxymin extends GXProcedure
{
   public getbaseimpmaxymin( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getbaseimpmaxymin.class ), "" );
   }

   public getbaseimpmaxymin( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             java.util.Date aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      getbaseimpmaxymin.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      getbaseimpmaxymin.this.AV10CliCod = aP0;
      getbaseimpmaxymin.this.AV11LiqPeriodo = aP1;
      getbaseimpmaxymin.this.AV12ProcesoLiquidacion = aP2;
      getbaseimpmaxymin.this.AV18permitirDesactualizadas = aP3;
      getbaseimpmaxymin.this.aP4 = aP4;
      getbaseimpmaxymin.this.aP5 = aP5;
      getbaseimpmaxymin.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9auxOpeCliId = "[base_imp_max]" ;
      if ( ! AV18permitirDesactualizadas )
      {
         GXv_char1[0] = AV13OpeCliValor ;
         GXv_char2[0] = AV14auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV10CliCod, AV9auxOpeCliId, AV11LiqPeriodo, AV12ProcesoLiquidacion, GXv_char1, GXv_char2) ;
         getbaseimpmaxymin.this.AV13OpeCliValor = GXv_char1[0] ;
         getbaseimpmaxymin.this.AV14auxError = GXv_char2[0] ;
      }
      else
      {
         GXv_char2[0] = AV13OpeCliValor ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV10CliCod, AV9auxOpeCliId, AV11LiqPeriodo, AV12ProcesoLiquidacion, GXv_char2) ;
         getbaseimpmaxymin.this.AV13OpeCliValor = GXv_char2[0] ;
      }
      if ( ! (GXutil.strcmp("", AV14auxError)==0) )
      {
         AV15error = AV14auxError ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV16base_imp_max = CommonUtil.decimalVal( AV13OpeCliValor, ".") ;
      AV9auxOpeCliId = "[base_imp_min]" ;
      if ( ! AV18permitirDesactualizadas )
      {
         GXv_char2[0] = AV13OpeCliValor ;
         GXv_char1[0] = AV14auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV10CliCod, AV9auxOpeCliId, AV11LiqPeriodo, AV12ProcesoLiquidacion, GXv_char2, GXv_char1) ;
         getbaseimpmaxymin.this.AV13OpeCliValor = GXv_char2[0] ;
         getbaseimpmaxymin.this.AV14auxError = GXv_char1[0] ;
      }
      else
      {
         GXv_char2[0] = AV13OpeCliValor ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV10CliCod, AV9auxOpeCliId, AV11LiqPeriodo, AV12ProcesoLiquidacion, GXv_char2) ;
         getbaseimpmaxymin.this.AV13OpeCliValor = GXv_char2[0] ;
      }
      if ( ! (GXutil.strcmp("", AV14auxError)==0) )
      {
         AV15error = AV14auxError ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV17base_imp_min = CommonUtil.decimalVal( AV13OpeCliValor, ".") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getbaseimpmaxymin.this.AV17base_imp_min;
      this.aP5[0] = getbaseimpmaxymin.this.AV16base_imp_max;
      this.aP6[0] = getbaseimpmaxymin.this.AV15error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17base_imp_min = DecimalUtil.ZERO ;
      AV16base_imp_max = DecimalUtil.ZERO ;
      AV15error = "" ;
      AV9auxOpeCliId = "" ;
      AV13OpeCliValor = "" ;
      AV14auxError = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private java.math.BigDecimal AV17base_imp_min ;
   private java.math.BigDecimal AV16base_imp_max ;
   private String AV12ProcesoLiquidacion ;
   private String AV9auxOpeCliId ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV18permitirDesactualizadas ;
   private boolean returnInSub ;
   private String AV13OpeCliValor ;
   private String AV15error ;
   private String AV14auxError ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
}

