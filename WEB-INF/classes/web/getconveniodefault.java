package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconveniodefault extends GXProcedure
{
   public getconveniodefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconveniodefault.class ), "" );
   }

   public getconveniodefault( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      getconveniodefault.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      getconveniodefault.this.AV11CliCod = aP0;
      getconveniodefault.this.AV10EmpCod = aP1;
      getconveniodefault.this.AV13ConCodigo = aP2;
      getconveniodefault.this.aP3 = aP3;
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
      this.aP3[0] = getconveniodefault.this.AV9ConveCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConveCodigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV13ConCodigo ;
   private String AV9ConveCodigo ;
   private String[] aP3 ;
}

