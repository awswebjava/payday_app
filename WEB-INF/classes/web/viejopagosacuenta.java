package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class viejopagosacuenta extends GXProcedure
{
   public viejopagosacuenta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( viejopagosacuenta.class ), "" );
   }

   public viejopagosacuenta( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      viejopagosacuenta.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      viejopagosacuenta.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8false = false ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = viejopagosacuenta.this.AV8false;
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
   private boolean AV8false ;
   private boolean[] aP0 ;
}

