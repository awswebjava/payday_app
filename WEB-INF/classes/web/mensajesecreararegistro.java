package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajesecreararegistro extends GXProcedure
{
   public mensajesecreararegistro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajesecreararegistro.class ), "" );
   }

   public mensajesecreararegistro( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             boolean aP4 )
   {
      mensajesecreararegistro.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        boolean aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             boolean aP4 ,
                             String[] aP5 )
   {
      mensajesecreararegistro.this.AV10CliCod = aP0;
      mensajesecreararegistro.this.AV9palabra = aP1;
      mensajesecreararegistro.this.AV11Descrip = aP2;
      mensajesecreararegistro.this.AV13confirmacion = aP3;
      mensajesecreararegistro.this.AV12puedeCrear = aP4;
      mensajesecreararegistro.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! AV13confirmacion )
      {
         AV8texto = GXutil.trim( AV9palabra) + httpContext.getMessage( " \"<i>", "") + GXutil.trim( AV11Descrip) + httpContext.getMessage( "</i>\" no existe. Seleccione una opción existente", "") ;
         if ( AV12puedeCrear )
         {
            AV8texto += httpContext.getMessage( " <b>o se creará nuevo registro de ", "") + GXutil.trim( AV9palabra) + httpContext.getMessage( "</b>", "") ;
         }
         else
         {
            AV8texto += "." ;
         }
      }
      else
      {
         if ( AV12puedeCrear )
         {
            if ( ( GXutil.strcmp(AV9palabra, httpContext.getMessage( "Lugar de Pago", "")) == 0 ) || ( GXutil.strcmp(AV9palabra, httpContext.getMessage( "Sindicato", "")) == 0 ) || ( GXutil.strcmp(AV9palabra, httpContext.getMessage( "Siniestrado", "")) == 0 ) || ( GXutil.strcmp(AV9palabra, httpContext.getMessage( "Banco", "")) == 0 ) )
            {
               AV8texto = httpContext.getMessage( "Se creará nuevo ", "") ;
            }
            else
            {
               AV8texto = httpContext.getMessage( "Se creará nueva ", "") ;
            }
            AV8texto += GXutil.trim( AV9palabra) ;
            if ( ! (GXutil.strcmp("", AV11Descrip)==0) )
            {
               AV8texto += " \"" + GXutil.trim( AV11Descrip) + "\"" ;
            }
         }
         else
         {
            AV8texto = httpContext.getMessage( "(Error, no se puede crear nuevo registro de ", "") + GXutil.trim( AV9palabra) + ") " ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = mensajesecreararegistro.this.AV8texto;
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
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV9palabra ;
   private boolean AV13confirmacion ;
   private boolean AV12puedeCrear ;
   private String AV11Descrip ;
   private String AV8texto ;
   private String[] aP5 ;
}

