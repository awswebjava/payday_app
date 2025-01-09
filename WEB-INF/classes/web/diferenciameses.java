package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diferenciameses extends GXProcedure
{
   public diferenciameses( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diferenciameses.class ), "" );
   }

   public diferenciameses( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            java.util.Date aP1 ,
                            java.util.Date aP2 ,
                            short aP3 )
   {
      diferenciameses.this.aP4 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        java.util.Date aP2 ,
                        short aP3 ,
                        short[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             java.util.Date aP2 ,
                             short aP3 ,
                             short[] aP4 )
   {
      diferenciameses.this.AV16CliCod = aP0;
      diferenciameses.this.AV15parmdesdeFecha = aP1;
      diferenciameses.this.AV14parmhastaFecha = aP2;
      diferenciameses.this.AV17limite = aP3;
      diferenciameses.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV13cantidad ;
      GXv_int2[0] = (short)(0) ;
      GXv_int3[0] = (short)(0) ;
      new web.diferenciamesesydias(remoteHandle, context).execute( AV16CliCod, AV15parmdesdeFecha, AV14parmhastaFecha, AV17limite, false, GXv_int1, GXv_int2, GXv_int3) ;
      diferenciameses.this.AV13cantidad = GXv_int1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = diferenciameses.this.AV13cantidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new short[1] ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17limite ;
   private short AV13cantidad ;
   private short GXv_int1[] ;
   private short GXv_int2[] ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV16CliCod ;
   private java.util.Date AV15parmdesdeFecha ;
   private java.util.Date AV14parmhastaFecha ;
   private short[] aP4 ;
}

