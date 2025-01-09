package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class generarconcauxfaltantes extends GXProcedure
{
   public generarconcauxfaltantes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( generarconcauxfaltantes.class ), "" );
   }

   public generarconcauxfaltantes( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 )
   {
      generarconcauxfaltantes.this.AV9CliCod = aP0;
      generarconcauxfaltantes.this.AV8EmpCod = aP1;
      generarconcauxfaltantes.this.AV13DLiqPeriodo = aP2;
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

   private short AV8EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private java.util.Date AV13DLiqPeriodo ;
}

