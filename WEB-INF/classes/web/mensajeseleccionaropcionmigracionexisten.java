package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeseleccionaropcionmigracionexisten extends GXProcedure
{
   public mensajeseleccionaropcionmigracionexisten( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeseleccionaropcionmigracionexisten.class ), "" );
   }

   public mensajeseleccionaropcionmigracionexisten( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             boolean aP5 )
   {
      mensajeseleccionaropcionmigracionexisten.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean aP4 ,
                        boolean aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             boolean aP5 ,
                             String[] aP6 )
   {
      mensajeseleccionaropcionmigracionexisten.this.AV10CliCod = aP0;
      mensajeseleccionaropcionmigracionexisten.this.AV8palabra = aP1;
      mensajeseleccionaropcionmigracionexisten.this.AV11descrip = aP2;
      mensajeseleccionaropcionmigracionexisten.this.AV13origDescrip = aP3;
      mensajeseleccionaropcionmigracionexisten.this.AV12obliga = aP4;
      mensajeseleccionaropcionmigracionexisten.this.AV15puntosSuspensivosEs = aP5;
      mensajeseleccionaropcionmigracionexisten.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strcmp(AV8palabra, httpContext.getMessage( "Actividad", "")) == 0 ) || ( GXutil.strcmp(AV8palabra, httpContext.getMessage( "Modalidad", "")) == 0 ) || ( GXutil.strcmp(AV8palabra, httpContext.getMessage( "Obra Social", "")) == 0 ) )
      {
         AV14pluralPalabra = GXutil.trim( AV8palabra) + httpContext.getMessage( "es", "") ;
      }
      else
      {
         AV14pluralPalabra = GXutil.trim( AV8palabra) + httpContext.getMessage( "s", "") ;
      }
      AV9mensaje = httpContext.getMessage( ".Existen ", "") + GXutil.trim( AV14pluralPalabra) + httpContext.getMessage( " similares a \"<i>", "") + GXutil.trim( AV11descrip) ;
      if ( AV15puntosSuspensivosEs )
      {
         AV9mensaje += "..." ;
      }
      AV9mensaje += httpContext.getMessage( "</i>\"", "") ;
      if ( AV12obliga )
      {
         AV9mensaje += httpContext.getMessage( ". Debe seleccionar ", "") + GXutil.trim( AV8palabra) + "." ;
      }
      else
      {
         AV9mensaje += httpContext.getMessage( ". Seleccione una, o <b>se creará nuevo registro \"", "") + GXutil.trim( AV13origDescrip) + httpContext.getMessage( "\"</b>.", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = mensajeseleccionaropcionmigracionexisten.this.AV9mensaje;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9mensaje = "" ;
      AV14pluralPalabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8palabra ;
   private String AV14pluralPalabra ;
   private boolean AV12obliga ;
   private boolean AV15puntosSuspensivosEs ;
   private String AV11descrip ;
   private String AV13origDescrip ;
   private String AV9mensaje ;
   private String[] aP6 ;
}

