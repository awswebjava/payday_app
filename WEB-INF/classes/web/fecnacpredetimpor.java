package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class fecnacpredetimpor extends GXProcedure
{
   public fecnacpredetimpor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( fecnacpredetimpor.class ), "" );
   }

   public fecnacpredetimpor( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( )
   {
      fecnacpredetimpor.this.aP0 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( java.util.Date[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( java.util.Date[] aP0 )
   {
      fecnacpredetimpor.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = fecnacpredetimpor.this.AV8fecha;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8fecha = GXutil.nullDate() ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.util.Date AV8fecha ;
   private java.util.Date[] aP0 ;
}

