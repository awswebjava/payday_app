package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getversionconvenio extends GXProcedure
{
   public getversionconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getversionconvenio.class ), "" );
   }

   public getversionconvenio( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          short aP3 ,
                          String aP4 )
   {
      getversionconvenio.this.aP5 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        int[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             int[] aP5 )
   {
      getversionconvenio.this.AV8CliCod = aP0;
      getversionconvenio.this.AV9EmpCod = aP1;
      getversionconvenio.this.AV10LegNumero = aP2;
      getversionconvenio.this.AV12PaiCod = aP3;
      getversionconvenio.this.AV13ConveCodigo = aP4;
      getversionconvenio.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV11CliConveVer ;
      new web.getversiondelegajo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_int1) ;
      getversionconvenio.this.AV11CliConveVer = GXv_int1[0] ;
      if ( (0==AV11CliConveVer) )
      {
         GXv_int1[0] = AV11CliConveVer ;
         new web.getversiondeconvenio(remoteHandle, context).execute( AV8CliCod, AV12PaiCod, AV13ConveCodigo, GXv_int1) ;
         getversionconvenio.this.AV11CliConveVer = GXv_int1[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getversionconvenio.this.AV11CliConveVer;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new int[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV12PaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int AV11CliConveVer ;
   private int GXv_int1[] ;
   private String AV13ConveCodigo ;
   private int[] aP5 ;
}

