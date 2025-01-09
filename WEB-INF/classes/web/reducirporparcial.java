package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reducirporparcial extends GXProcedure
{
   public reducirporparcial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reducirporparcial.class ), "" );
   }

   public reducirporparcial( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.util.Date aP3 ,
                                           java.math.BigDecimal aP4 ,
                                           java.math.BigDecimal[] aP5 ,
                                           java.math.BigDecimal[] aP6 )
   {
      reducirporparcial.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      reducirporparcial.this.AV14CliCod = aP0;
      reducirporparcial.this.AV13EmpCod = aP1;
      reducirporparcial.this.AV12LegNumero = aP2;
      reducirporparcial.this.AV11LiqPeriodo = aP3;
      reducirporparcial.this.AV17OriginalImportes = aP4;
      reducirporparcial.this.aP5 = aP5;
      reducirporparcial.this.aP6 = aP6;
      reducirporparcial.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10Importes = AV17OriginalImportes ;
      GXv_boolean1[0] = AV20MprEsParcial ;
      GXv_decimal2[0] = AV16horasSemanaNormal ;
      GXv_decimal3[0] = AV19LegHorasSem ;
      new web.reduceporparcialdeterminado(remoteHandle, context).execute( AV14CliCod, AV13EmpCod, AV12LegNumero, GXv_boolean1, GXv_decimal2, GXv_decimal3) ;
      reducirporparcial.this.AV20MprEsParcial = GXv_boolean1[0] ;
      reducirporparcial.this.AV16horasSemanaNormal = GXv_decimal2[0] ;
      reducirporparcial.this.AV19LegHorasSem = GXv_decimal3[0] ;
      if ( AV20MprEsParcial )
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16horasSemanaNormal)==0) )
         {
            AV10Importes = AV10Importes.divide(AV16horasSemanaNormal, 18, java.math.RoundingMode.DOWN) ;
            AV10Importes = AV10Importes.multiply(AV19LegHorasSem) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = reducirporparcial.this.AV10Importes;
      this.aP6[0] = reducirporparcial.this.AV16horasSemanaNormal;
      this.aP7[0] = reducirporparcial.this.AV19LegHorasSem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10Importes = DecimalUtil.ZERO ;
      AV16horasSemanaNormal = DecimalUtil.ZERO ;
      AV19LegHorasSem = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV17OriginalImportes ;
   private java.math.BigDecimal AV10Importes ;
   private java.math.BigDecimal AV16horasSemanaNormal ;
   private java.math.BigDecimal AV19LegHorasSem ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV20MprEsParcial ;
   private boolean GXv_boolean1[] ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
}

