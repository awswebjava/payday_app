package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaicod extends GXProcedure
{
   public getpaicod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaicod.class ), "" );
   }

   public getpaicod( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getpaicod.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      getpaicod.this.AV8clicod = aP0;
      getpaicod.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9PaiCod = (short)(12) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaicod.this.AV9PaiCod;
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

   private short AV9PaiCod ;
   private short Gx_err ;
   private int AV8clicod ;
   private short[] aP1 ;
}

