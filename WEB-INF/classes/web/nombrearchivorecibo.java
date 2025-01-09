package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nombrearchivorecibo extends GXProcedure
{
   public nombrearchivorecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nombrearchivorecibo.class ), "" );
   }

   public nombrearchivorecibo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      nombrearchivorecibo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String[] aP7 )
   {
      nombrearchivorecibo.this.AV9CliCod = aP0;
      nombrearchivorecibo.this.AV10EmpCod = aP1;
      nombrearchivorecibo.this.AV11LiqNro = aP2;
      nombrearchivorecibo.this.AV12LegNumero = aP3;
      nombrearchivorecibo.this.AV14tipoRecibo = aP4;
      nombrearchivorecibo.this.AV16extension = aP5;
      nombrearchivorecibo.this.AV18sufijoPalabra = aP6;
      nombrearchivorecibo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV13reciboPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.palabrarecibo(remoteHandle, context).execute( GXv_char2) ;
      nombrearchivorecibo.this.GXt_char1 = GXv_char2[0] ;
      AV13reciboPalabra = GXutil.trim( GXt_char1) ;
      AV13reciboPalabra += GXutil.trim( AV14tipoRecibo) ;
      AV8texto = GXutil.trim( AV13reciboPalabra) + "_" + GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV10EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV11LiqNro, 8, 0)) + "_" + GXutil.trim( GXutil.str( AV12LegNumero, 8, 0)) ;
      if ( ! (GXutil.strcmp("", AV18sufijoPalabra)==0) )
      {
         AV8texto += GXutil.trim( AV18sufijoPalabra) ;
      }
      if ( ! (GXutil.strcmp("", AV16extension)==0) )
      {
         AV8texto += "." + GXutil.trim( AV16extension) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = nombrearchivorecibo.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      AV13reciboPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV12LegNumero ;
   private String AV14tipoRecibo ;
   private String AV16extension ;
   private String AV18sufijoPalabra ;
   private String AV13reciboPalabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV8texto ;
   private String[] aP7 ;
}

