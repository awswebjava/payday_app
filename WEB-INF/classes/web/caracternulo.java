package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class caracternulo extends GXProcedure
{
   public caracternulo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( caracternulo.class ), "" );
   }

   public caracternulo( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      caracternulo.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      caracternulo.this.AV9clicod = aP0;
      caracternulo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8character = httpContext.getMessage( "Ninguno", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = caracternulo.this.AV8character;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8character = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9clicod ;
   private String AV8character ;
   private String[] aP1 ;
}

