package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getquerystring extends GXProcedure
{
   public getquerystring( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getquerystring.class ), "" );
   }

   public getquerystring( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      getquerystring.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      getquerystring.this.AV9CliCod = aP0;
      getquerystring.this.AV10EmpCod = aP1;
      getquerystring.this.AV11LiqNro = aP2;
      getquerystring.this.AV12LegNumero = aP3;
      getquerystring.this.AV13ConCodigo = aP4;
      getquerystring.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8queryString = httpContext.getMessage( "/?CliCod=", "") + GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) + httpContext.getMessage( ",EmpCod=", "") + GXutil.trim( GXutil.str( AV10EmpCod, 4, 0)) + httpContext.getMessage( ",LiqNro=", "") + GXutil.trim( GXutil.str( AV11LiqNro, 8, 0)) + httpContext.getMessage( ",LegNumero=", "") + GXutil.trim( GXutil.str( AV12LegNumero, 8, 0)) + httpContext.getMessage( ",ConCodigo=", "") + GXutil.trim( AV13ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getquerystring.this.AV8queryString;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8queryString = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV12LegNumero ;
   private String AV13ConCodigo ;
   private String AV8queryString ;
   private String[] aP5 ;
}

