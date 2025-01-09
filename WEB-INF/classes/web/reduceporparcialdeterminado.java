package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reduceporparcialdeterminado extends GXProcedure
{
   public reduceporparcialdeterminado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reduceporparcialdeterminado.class ), "" );
   }

   public reduceporparcialdeterminado( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           boolean[] aP3 ,
                                           java.math.BigDecimal[] aP4 )
   {
      reduceporparcialdeterminado.this.aP5 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      reduceporparcialdeterminado.this.AV8CliCod = aP0;
      reduceporparcialdeterminado.this.AV9EmpCod = aP1;
      reduceporparcialdeterminado.this.AV10LegNumero = aP2;
      reduceporparcialdeterminado.this.aP3 = aP3;
      reduceporparcialdeterminado.this.aP4 = aP4;
      reduceporparcialdeterminado.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV13MprCod ;
      new web.getlegajomodalidad(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_char1) ;
      reduceporparcialdeterminado.this.AV13MprCod = GXv_char1[0] ;
      GXv_boolean2[0] = AV14MprEsParcial ;
      new web.getmodalidadparcial(remoteHandle, context).execute( AV13MprCod, GXv_boolean2) ;
      reduceporparcialdeterminado.this.AV14MprEsParcial = GXv_boolean2[0] ;
      if ( AV14MprEsParcial )
      {
         GXv_decimal3[0] = AV11horasSemanaNormal ;
         new web.gethorassemananormalporlegajo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_decimal3) ;
         reduceporparcialdeterminado.this.AV11horasSemanaNormal = GXv_decimal3[0] ;
         GXv_decimal3[0] = AV12LegHorasSem ;
         new web.getleghorassemana(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_decimal3) ;
         reduceporparcialdeterminado.this.AV12LegHorasSem = GXv_decimal3[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = reduceporparcialdeterminado.this.AV14MprEsParcial;
      this.aP4[0] = reduceporparcialdeterminado.this.AV11horasSemanaNormal;
      this.aP5[0] = reduceporparcialdeterminado.this.AV12LegHorasSem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11horasSemanaNormal = DecimalUtil.ZERO ;
      AV12LegHorasSem = DecimalUtil.ZERO ;
      AV13MprCod = "" ;
      GXv_char1 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV11horasSemanaNormal ;
   private java.math.BigDecimal AV12LegHorasSem ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV13MprCod ;
   private String GXv_char1[] ;
   private boolean AV14MprEsParcial ;
   private boolean GXv_boolean2[] ;
   private java.math.BigDecimal[] aP5 ;
   private boolean[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
}

