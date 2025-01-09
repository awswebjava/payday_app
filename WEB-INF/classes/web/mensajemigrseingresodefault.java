package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajemigrseingresodefault extends GXProcedure
{
   public mensajemigrseingresodefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajemigrseingresodefault.class ), "" );
   }

   public mensajemigrseingresodefault( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      mensajemigrseingresodefault.this.aP3 = new String[] {""};
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
      mensajemigrseingresodefault.this.AV11CliCod = aP0;
      mensajemigrseingresodefault.this.AV10palabra = aP1;
      mensajemigrseingresodefault.this.AV9valor = aP2;
      mensajemigrseingresodefault.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8texto ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV11CliCod, GXv_char2) ;
      mensajemigrseingresodefault.this.GXt_char1 = GXv_char2[0] ;
      AV8texto = httpContext.getMessage( "Se asignó automáticamente valor por defecto \"<b>", "") + GXutil.strReplace( AV9valor, GXt_char1, "") + httpContext.getMessage( "</b>\" en ", "") + GXutil.trim( AV10palabra) + "." ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = mensajemigrseingresodefault.this.AV8texto;
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
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV10palabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV9valor ;
   private String AV8texto ;
   private String[] aP3 ;
}

