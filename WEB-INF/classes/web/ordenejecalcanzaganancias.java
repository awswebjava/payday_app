package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ordenejecalcanzaganancias extends GXProcedure
{
   public ordenejecalcanzaganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ordenejecalcanzaganancias.class ), "" );
   }

   public ordenejecalcanzaganancias( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( )
   {
      ordenejecalcanzaganancias.this.aP0 = new long[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( long[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long[] aP0 )
   {
      ordenejecalcanzaganancias.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ConOrdEjec = 4050000 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = ordenejecalcanzaganancias.this.AV8ConOrdEjec;
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
   private long AV8ConOrdEjec ;
   private long[] aP0 ;
}

