package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeconfirmaciondefault extends GXProcedure
{
   public mensajeconfirmaciondefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeconfirmaciondefault.class ), "" );
   }

   public mensajeconfirmaciondefault( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      mensajeconfirmaciondefault.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      mensajeconfirmaciondefault.this.AV10CliCod = aP0;
      mensajeconfirmaciondefault.this.AV11accionPalabra = aP1;
      mensajeconfirmaciondefault.this.AV9que = aP2;
      mensajeconfirmaciondefault.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = httpContext.getMessage( "¿Confirma ", "") + GXutil.trim( AV11accionPalabra) + " " + GXutil.trim( AV9que) + "?" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = mensajeconfirmaciondefault.this.AV8texto;
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
   private String AV11accionPalabra ;
   private String AV9que ;
   private String AV8texto ;
   private String[] aP3 ;
}

