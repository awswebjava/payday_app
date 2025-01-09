package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sacaracentos2 extends GXProcedure
{
   public sacaracentos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sacaracentos2.class ), "" );
   }

   public sacaracentos2( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      sacaracentos2.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      sacaracentos2.this.AV8texto = aP0;
      sacaracentos2.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9texto2 = GXutil.strReplace( AV8texto, httpContext.getMessage( "Á", ""), httpContext.getMessage( "A", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "É", ""), httpContext.getMessage( "E", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "Í", ""), httpContext.getMessage( "I", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "Ó", ""), httpContext.getMessage( "O", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "Ú", ""), httpContext.getMessage( "U", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "á", ""), httpContext.getMessage( "a", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "é", ""), httpContext.getMessage( "e", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "í", ""), httpContext.getMessage( "i", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "ó", ""), httpContext.getMessage( "o", "")) ;
      AV9texto2 = GXutil.strReplace( AV9texto2, httpContext.getMessage( "ú", ""), httpContext.getMessage( "u", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = sacaracentos2.this.AV9texto2;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9texto2 = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8texto ;
   private String AV9texto2 ;
   private String[] aP1 ;
}

