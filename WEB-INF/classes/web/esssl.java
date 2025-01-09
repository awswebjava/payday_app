package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esssl extends GXProcedure
{
   public esssl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esssl.class ), "" );
   }

   public esssl( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      esssl.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      esssl.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8esSSL = (short)(0) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = esssl.this.AV8esSSL;
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

   private short AV8esSSL ;
   private short Gx_err ;
   private short[] aP0 ;
}

