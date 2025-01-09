package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class replicarimportadastest extends GXProcedure
{
   public replicarimportadastest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( replicarimportadastest.class ), "" );
   }

   public replicarimportadastest( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        boolean aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             boolean aP5 )
   {
      replicarimportadastest.this.AV8CliCod = aP0;
      replicarimportadastest.this.AV9otraEmpCod = aP1;
      replicarimportadastest.this.AV10EmpCod = aP2;
      replicarimportadastest.this.AV34parmLiqPeriodo = aP3;
      replicarimportadastest.this.AV35parmTLiqCod = aP4;
      replicarimportadastest.this.AV48eliminarliquidaciones = aP5;
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

   private short AV9otraEmpCod ;
   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV35parmTLiqCod ;
   private java.util.Date AV34parmLiqPeriodo ;
   private boolean AV48eliminarliquidaciones ;
}

