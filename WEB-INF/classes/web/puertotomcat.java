package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class puertotomcat extends GXProcedure
{
   public puertotomcat( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( puertotomcat.class ), "" );
   }

   public puertotomcat( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( )
   {
      puertotomcat.this.aP0 = new int[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( int[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int[] aP0 )
   {
      puertotomcat.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8puerto = 8080 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = puertotomcat.this.AV8puerto;
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
   private int AV8puerto ;
   private int[] aP0 ;
}

