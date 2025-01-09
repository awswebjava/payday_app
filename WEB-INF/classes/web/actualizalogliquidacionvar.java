package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizalogliquidacionvar extends GXProcedure
{
   public actualizalogliquidacionvar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizalogliquidacionvar.class ), "" );
   }

   public actualizalogliquidacionvar( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      actualizalogliquidacionvar.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      actualizalogliquidacionvar.this.AV10clicod = aP0;
      actualizalogliquidacionvar.this.AV13appendLiqLog = aP1;
      actualizalogliquidacionvar.this.AV12LiqLog = aP2[0];
      this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12LiqLog += AV13appendLiqLog + httpContext.getMessage( "<br>", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = actualizalogliquidacionvar.this.AV12LiqLog;
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
   private int AV10clicod ;
   private String AV13appendLiqLog ;
   private String AV12LiqLog ;
   private String[] aP2 ;
}

