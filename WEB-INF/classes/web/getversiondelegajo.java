package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getversiondelegajo extends GXProcedure
{
   public getversiondelegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getversiondelegajo.class ), "" );
   }

   public getversiondelegajo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 )
   {
      getversiondelegajo.this.aP3 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int[] aP3 )
   {
      getversiondelegajo.this.AV11CliCod = aP0;
      getversiondelegajo.this.AV10EmpCod = aP1;
      getversiondelegajo.this.AV8LegNumero = aP2;
      getversiondelegajo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9LegConveVersionCli = AV11CliCod ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getversiondelegajo.this.AV9LegConveVersionCli;
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

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int AV9LegConveVersionCli ;
   private int[] aP3 ;
}

