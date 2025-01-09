package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sacarformato extends GXProcedure
{
   public sacarformato( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sacarformato.class ), "" );
   }

   public sacarformato( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      sacarformato.this.aP1 = new String[] {""};
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
      sacarformato.this.AV9parmTexto = aP0;
      sacarformato.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = GXutil.strReplace( AV9parmTexto, httpContext.getMessage( "<i>", ""), "") ;
      AV8texto = GXutil.strReplace( AV8texto, httpContext.getMessage( "</i>", ""), "") ;
      AV8texto = GXutil.strReplace( AV8texto, httpContext.getMessage( "<b>", ""), "") ;
      AV8texto = GXutil.strReplace( AV8texto, httpContext.getMessage( "</b>", ""), "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = sacarformato.this.AV8texto;
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
   private String AV9parmTexto ;
   private String AV8texto ;
   private String[] aP1 ;
}

