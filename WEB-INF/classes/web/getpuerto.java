package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuerto extends GXProcedure
{
   public getpuerto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuerto.class ), "" );
   }

   public getpuerto( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 )
   {
      getpuerto.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int[] aP1 )
   {
      getpuerto.this.AV9CliCod = aP0;
      getpuerto.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10puerto = 8081 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpuerto.this.AV10puerto;
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
   private int AV9CliCod ;
   private int AV10puerto ;
   private int[] aP1 ;
}

