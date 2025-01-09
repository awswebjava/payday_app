package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class totalpalabra extends GXProcedure
{
   public totalpalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( totalpalabra.class ), "" );
   }

   public totalpalabra( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      totalpalabra.this.aP1 = new String[] {""};
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
      totalpalabra.this.AV10clicod = aP0;
      totalpalabra.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9palabra = httpContext.getMessage( "T", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = totalpalabra.this.AV9palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10clicod ;
   private String AV9palabra ;
   private String[] aP1 ;
}

