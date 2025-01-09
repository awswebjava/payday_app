package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclinextfecha extends GXProcedure
{
   public getopeclinextfecha( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclinextfecha.class ), "" );
   }

   public getopeclinextfecha( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     String aP1 ,
                                     java.util.Date aP2 )
   {
      getopeclinextfecha.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 )
   {
      getopeclinextfecha.this.AV10CliCod = aP0;
      getopeclinextfecha.this.AV8OpeCliId = aP1;
      getopeclinextfecha.this.AV15parmOpeCliVig = aP2;
      getopeclinextfecha.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_date1[0] = AV11OpeCliVig ;
      GXv_int2[0] = AV16VarFrecAct ;
      new web.getopecliultifecha(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, AV15parmOpeCliVig, GXv_date1, GXv_int2) ;
      getopeclinextfecha.this.AV11OpeCliVig = GXv_date1[0] ;
      getopeclinextfecha.this.AV16VarFrecAct = GXv_int2[0] ;
      AV11OpeCliVig = GXutil.addmth( AV11OpeCliVig, AV16VarFrecAct) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getopeclinextfecha.this.AV11OpeCliVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11OpeCliVig = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_int2 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16VarFrecAct ;
   private byte GXv_int2[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8OpeCliId ;
   private java.util.Date AV15parmOpeCliVig ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date[] aP3 ;
}

