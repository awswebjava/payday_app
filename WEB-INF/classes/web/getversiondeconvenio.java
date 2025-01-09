package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getversiondeconvenio extends GXProcedure
{
   public getversiondeconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getversiondeconvenio.class ), "" );
   }

   public getversiondeconvenio( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          String aP2 )
   {
      getversiondeconvenio.this.aP3 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        int[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             int[] aP3 )
   {
      getversiondeconvenio.this.AV8CliCod = aP0;
      getversiondeconvenio.this.AV9CliPaiConve = aP1;
      getversiondeconvenio.this.AV10CliConvenio = aP2;
      getversiondeconvenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11CliConveVer = AV8CliCod ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getversiondeconvenio.this.AV11CliConveVer;
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

   private short AV9CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11CliConveVer ;
   private String AV10CliConvenio ;
   private int[] aP3 ;
}

