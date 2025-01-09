package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class manejarerrorliquidacion extends GXProcedure
{
   public manejarerrorliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( manejarerrorliquidacion.class ), "" );
   }

   public manejarerrorliquidacion( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             boolean[] aP12 ,
                             boolean[] aP13 )
   {
      manejarerrorliquidacion.this.aP14 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        boolean[] aP12 ,
                        boolean[] aP13 ,
                        String[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             boolean[] aP12 ,
                             boolean[] aP13 ,
                             String[] aP14 )
   {
      manejarerrorliquidacion.this.AV8CliCod = aP0;
      manejarerrorliquidacion.this.AV9EmpCod = aP1;
      manejarerrorliquidacion.this.AV13LiqNro = aP2;
      manejarerrorliquidacion.this.AV14LiqRelNro = aP3;
      manejarerrorliquidacion.this.AV12LiqFecImp = aP4;
      manejarerrorliquidacion.this.AV15retroGananciasError = aP5;
      manejarerrorliquidacion.this.AV10errorCiclicoHay = aP6;
      manejarerrorliquidacion.this.AV11GeneralConceptosOK = aP7;
      manejarerrorliquidacion.this.AV23basesError = aP8;
      manejarerrorliquidacion.this.AV16clientId = aP9;
      manejarerrorliquidacion.this.AV21LiqLote = aP10;
      manejarerrorliquidacion.this.AV24todoLegError = aP11;
      manejarerrorliquidacion.this.aP12 = aP12;
      manejarerrorliquidacion.this.aP13 = aP13;
      manejarerrorliquidacion.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.dateCompare(GXutil.nullDate(), AV12LiqFecImp) && ( ! (GXutil.strcmp("", AV15retroGananciasError)==0) || ( AV10errorCiclicoHay ) || ! AV11GeneralConceptosOK || ! (GXutil.strcmp("", AV23basesError)==0) ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "error 1", "")) ;
         if ( (0==AV14LiqRelNro) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "error 2", "")) ;
            if ( ! (GXutil.strcmp("", AV23basesError)==0) )
            {
               AV17errorTexto = AV23basesError ;
            }
            else
            {
               if ( ! (GXutil.strcmp("", AV15retroGananciasError)==0) )
               {
                  AV17errorTexto = AV15retroGananciasError ;
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "error 3", "")) ;
                  AV17errorTexto = GXutil.trim( AV24todoLegError) ;
               }
            }
            AV20ErrorHay = true ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = manejarerrorliquidacion.this.AV20ErrorHay;
      this.aP13[0] = manejarerrorliquidacion.this.AV18sinProcesarHay;
      this.aP14[0] = manejarerrorliquidacion.this.AV17errorTexto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17errorTexto = "" ;
      AV27Pgmname = "" ;
      AV27Pgmname = "manejarErrorLiquidacion" ;
      /* GeneXus formulas. */
      AV27Pgmname = "manejarErrorLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13LiqNro ;
   private int AV14LiqRelNro ;
   private String AV27Pgmname ;
   private java.util.Date AV12LiqFecImp ;
   private boolean AV10errorCiclicoHay ;
   private boolean AV11GeneralConceptosOK ;
   private boolean AV20ErrorHay ;
   private boolean AV18sinProcesarHay ;
   private String AV15retroGananciasError ;
   private String AV23basesError ;
   private String AV16clientId ;
   private String AV21LiqLote ;
   private String AV24todoLegError ;
   private String AV17errorTexto ;
   private String[] aP14 ;
   private boolean[] aP12 ;
   private boolean[] aP13 ;
}

