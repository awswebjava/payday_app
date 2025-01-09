package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class htmlreemplazartags extends GXProcedure
{
   public htmlreemplazartags( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( htmlreemplazartags.class ), "" );
   }

   public htmlreemplazartags( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      htmlreemplazartags.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      htmlreemplazartags.this.AV8htmlFormulaAux = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strSearch( AV8htmlFormulaAux, httpContext.getMessage( "</span>", ""), 1) == 0 )
      {
         AV8htmlFormulaAux = GXutil.strReplace( AV8htmlFormulaAux, "<", "&#60;") ;
         AV8htmlFormulaAux = GXutil.strReplace( AV8htmlFormulaAux, ">", "&#62;") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = htmlreemplazartags.this.AV8htmlFormulaAux;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8htmlFormulaAux ;
   private String[] aP0 ;
}

