package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class replacefinalconequis extends GXProcedure
{
   public replacefinalconequis( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( replacefinalconequis.class ), "" );
   }

   public replacefinalconequis( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      replacefinalconequis.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      replacefinalconequis.this.AV8valor = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strSearch( AV8valor, httpContext.getMessage( " X]", ""), 1) != 0 )
      {
         AV8valor = GXutil.strReplace( AV8valor, httpContext.getMessage( "X]", ""), "") ;
      }
      if ( GXutil.strSearch( AV8valor, httpContext.getMessage( " X}", ""), 1) != 0 )
      {
         AV8valor = GXutil.strReplace( AV8valor, httpContext.getMessage( "X}", ""), "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = replacefinalconequis.this.AV8valor;
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
   private String AV8valor ;
   private String[] aP0 ;
}

