package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pisogananciassacreal extends GXProcedure
{
   public pisogananciassacreal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pisogananciassacreal.class ), "" );
   }

   public pisogananciassacreal( int remoteHandle ,
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
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      pisogananciassacreal.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 )
   {
      pisogananciassacreal.this.AV8CliCod = aP0;
      pisogananciassacreal.this.AV16EmpCod = aP1;
      pisogananciassacreal.this.AV17LegNumero = aP2;
      pisogananciassacreal.this.AV11LiqPeriodo = aP3;
      pisogananciassacreal.this.AV20ActualLiqPeriodo = aP4;
      pisogananciassacreal.this.AV10ProcesoLiquidacion = aP5;
      pisogananciassacreal.this.aP6 = aP6;
      pisogananciassacreal.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV10ProcesoLiquidacion, "Calculo") == 0 )
      {
         AV15fecha = AV11LiqPeriodo ;
      }
      else
      {
         AV15fecha = AV20ActualLiqPeriodo ;
      }
      AV9OpeCliId = "[piso_ganancias_SAC]" ;
      GXv_char1[0] = AV12OpeCliValor ;
      GXv_char2[0] = AV21auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV8CliCod, AV9OpeCliId, AV15fecha, AV10ProcesoLiquidacion, GXv_char1, GXv_char2) ;
      pisogananciassacreal.this.AV12OpeCliValor = GXv_char1[0] ;
      pisogananciassacreal.this.AV21auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV21auxError)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13Importes = CommonUtil.decimalVal( AV12OpeCliValor, ".") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = pisogananciassacreal.this.AV13Importes;
      this.aP7[0] = pisogananciassacreal.this.AV21auxError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Importes = DecimalUtil.ZERO ;
      AV21auxError = "" ;
      AV15fecha = GXutil.nullDate() ;
      AV9OpeCliId = "" ;
      AV12OpeCliValor = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV16EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17LegNumero ;
   private java.math.BigDecimal AV13Importes ;
   private String AV10ProcesoLiquidacion ;
   private String AV9OpeCliId ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date AV20ActualLiqPeriodo ;
   private java.util.Date AV15fecha ;
   private boolean returnInSub ;
   private String AV12OpeCliValor ;
   private String AV21auxError ;
   private String[] aP7 ;
   private java.math.BigDecimal[] aP6 ;
}

