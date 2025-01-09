package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrangoperiodos extends GXProcedure
{
   public getrangoperiodos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrangoperiodos.class ), "" );
   }

   public getrangoperiodos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     int aP3 ,
                                     String aP4 ,
                                     byte aP5 ,
                                     java.util.Date aP6 ,
                                     boolean aP7 ,
                                     java.util.Date[] aP8 )
   {
      getrangoperiodos.this.aP9 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        byte aP5 ,
                        java.util.Date aP6 ,
                        boolean aP7 ,
                        java.util.Date[] aP8 ,
                        java.util.Date[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             byte aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             java.util.Date[] aP8 ,
                             java.util.Date[] aP9 )
   {
      getrangoperiodos.this.AV13CliCod = aP0;
      getrangoperiodos.this.AV17EmpCod = aP1;
      getrangoperiodos.this.AV18LiqNro = aP2;
      getrangoperiodos.this.AV19LegNumero = aP3;
      getrangoperiodos.this.AV14TLiqCod = aP4;
      getrangoperiodos.this.AV8LegClase = aP5;
      getrangoperiodos.this.AV11LiqPeriodo = aP6;
      getrangoperiodos.this.AV15controlAdelantoVacaciones = aP7;
      getrangoperiodos.this.aP8 = aP8;
      getrangoperiodos.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12quincenaTLiqCod ;
      GXt_char2 = AV12quincenaTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getrangoperiodos.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char2, GXv_char4) ;
      getrangoperiodos.this.GXt_char1 = GXv_char4[0] ;
      AV12quincenaTLiqCod = GXt_char1 ;
      if ( ( GXutil.strcmp(AV14TLiqCod, AV12quincenaTLiqCod) == 0 ) && ( AV15controlAdelantoVacaciones != true ) )
      {
         AV9ultimoDiaPeriodo = localUtil.ymdtod( GXutil.year( AV11LiqPeriodo), GXutil.month( AV11LiqPeriodo), 15) ;
         AV10primerDiaPeriodo = AV11LiqPeriodo ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "quin1", "")) ;
      }
      else
      {
         if ( ( AV8LegClase != 1 ) && ! AV15controlAdelantoVacaciones )
         {
            GXt_char2 = AV20adelantoVacTLiqCod ;
            GXt_char1 = AV20adelantoVacTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            getrangoperiodos.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
            getrangoperiodos.this.GXt_char2 = GXv_char3[0] ;
            AV20adelantoVacTLiqCod = GXt_char2 ;
         }
         if ( ( AV8LegClase == 1 ) || ( AV15controlAdelantoVacaciones ) || ( GXutil.strcmp(AV14TLiqCod, AV20adelantoVacTLiqCod) == 0 ) )
         {
            AV9ultimoDiaPeriodo = GXutil.eomdate( AV11LiqPeriodo) ;
            AV10primerDiaPeriodo = AV11LiqPeriodo ;
         }
         else
         {
            AV9ultimoDiaPeriodo = GXutil.eomdate( AV11LiqPeriodo) ;
            AV10primerDiaPeriodo = localUtil.ymdtod( GXutil.year( AV11LiqPeriodo), GXutil.month( AV11LiqPeriodo), 16) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "quin2", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getrangoperiodos.this.AV10primerDiaPeriodo;
      this.aP9[0] = getrangoperiodos.this.AV9ultimoDiaPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10primerDiaPeriodo = GXutil.nullDate() ;
      AV9ultimoDiaPeriodo = GXutil.nullDate() ;
      AV12quincenaTLiqCod = "" ;
      AV23Pgmname = "" ;
      AV20adelantoVacTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV23Pgmname = "getRangoPeriodos" ;
      /* GeneXus formulas. */
      AV23Pgmname = "getRangoPeriodos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LegClase ;
   private short AV17EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV18LiqNro ;
   private int AV19LegNumero ;
   private String AV14TLiqCod ;
   private String AV12quincenaTLiqCod ;
   private String AV23Pgmname ;
   private String AV20adelantoVacTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date AV10primerDiaPeriodo ;
   private java.util.Date AV9ultimoDiaPeriodo ;
   private boolean AV15controlAdelantoVacaciones ;
   private java.util.Date[] aP9 ;
   private java.util.Date[] aP8 ;
}

