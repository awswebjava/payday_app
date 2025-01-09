package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrangoagendaliquidacion extends GXProcedure
{
   public getrangoagendaliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrangoagendaliquidacion.class ), "" );
   }

   public getrangoagendaliquidacion( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     int aP3 ,
                                     java.util.Date aP4 ,
                                     String aP5 ,
                                     byte aP6 ,
                                     java.util.Date[] aP7 )
   {
      getrangoagendaliquidacion.this.aP8 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        java.util.Date[] aP7 ,
                        java.util.Date[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             java.util.Date[] aP7 ,
                             java.util.Date[] aP8 )
   {
      getrangoagendaliquidacion.this.AV19CliCod = aP0;
      getrangoagendaliquidacion.this.AV20EmpCod = aP1;
      getrangoagendaliquidacion.this.AV16LiqNro = aP2;
      getrangoagendaliquidacion.this.AV15LegNumero = aP3;
      getrangoagendaliquidacion.this.AV11LiqPeriodo = aP4;
      getrangoagendaliquidacion.this.AV9TLiqCod = aP5;
      getrangoagendaliquidacion.this.AV10LegClase = aP6;
      getrangoagendaliquidacion.this.aP7 = aP7;
      getrangoagendaliquidacion.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8adelantoVacTLiqCod ;
      GXt_char2 = AV8adelantoVacTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getrangoagendaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char2, GXv_char4) ;
      getrangoagendaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      AV8adelantoVacTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV9TLiqCod, AV8adelantoVacTLiqCod) == 0 )
      {
         GXv_date5[0] = AV12primerDiaPeriodo ;
         GXv_date6[0] = AV13ultimoDiaPeriodo ;
         new web.getrangoperiodos(remoteHandle, context).execute( AV19CliCod, AV20EmpCod, AV16LiqNro, AV15LegNumero, AV9TLiqCod, AV10LegClase, AV11LiqPeriodo, true, GXv_date5, GXv_date6) ;
         getrangoagendaliquidacion.this.AV12primerDiaPeriodo = GXv_date5[0] ;
         getrangoagendaliquidacion.this.AV13ultimoDiaPeriodo = GXv_date6[0] ;
      }
      else
      {
         GXv_date6[0] = AV12primerDiaPeriodo ;
         GXv_date5[0] = AV13ultimoDiaPeriodo ;
         new web.getliqperdesyhas(remoteHandle, context).execute( AV19CliCod, AV20EmpCod, AV16LiqNro, GXv_date6, GXv_date5) ;
         getrangoagendaliquidacion.this.AV12primerDiaPeriodo = GXv_date6[0] ;
         getrangoagendaliquidacion.this.AV13ultimoDiaPeriodo = GXv_date5[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getrangoagendaliquidacion.this.AV12primerDiaPeriodo;
      this.aP8[0] = getrangoagendaliquidacion.this.AV13ultimoDiaPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12primerDiaPeriodo = GXutil.nullDate() ;
      AV13ultimoDiaPeriodo = GXutil.nullDate() ;
      AV8adelantoVacTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_date5 = new java.util.Date[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10LegClase ;
   private short AV20EmpCod ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV16LiqNro ;
   private int AV15LegNumero ;
   private String AV9TLiqCod ;
   private String AV8adelantoVacTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date AV12primerDiaPeriodo ;
   private java.util.Date AV13ultimoDiaPeriodo ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date[] aP8 ;
   private java.util.Date[] aP7 ;
}

