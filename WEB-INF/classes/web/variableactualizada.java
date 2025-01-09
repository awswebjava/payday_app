package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variableactualizada extends GXProcedure
{
   public variableactualizada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variableactualizada.class ), "" );
   }

   public variableactualizada( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              java.util.Date aP2 ,
                              java.util.Date aP3 )
   {
      variableactualizada.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 )
   {
      variableactualizada.this.AV10CliCod = aP0;
      variableactualizada.this.AV8OpeCliId = aP1;
      variableactualizada.this.AV17parm_UltiOpeCliVig = aP2;
      variableactualizada.this.AV20fecha = aP3;
      variableactualizada.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV17parm_UltiOpeCliVig)) )
      {
         GXv_date1[0] = AV18ultiOpeCliVig ;
         new web.getultifecvar(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, AV21vaciaFecha, GXv_date1) ;
         variableactualizada.this.AV18ultiOpeCliVig = GXv_date1[0] ;
      }
      else
      {
         AV18ultiOpeCliVig = AV17parm_UltiOpeCliVig ;
      }
      GXv_int2[0] = AV9VarFrecAct ;
      new web.getvarfrectact(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_int2) ;
      variableactualizada.this.AV9VarFrecAct = GXv_int2[0] ;
      GXv_int3[0] = AV19diferenciaMeses ;
      new web.diferenciameses(remoteHandle, context).execute( AV10CliCod, AV18ultiOpeCliVig, AV20fecha, (short)(99), GXv_int3) ;
      variableactualizada.this.AV19diferenciaMeses = GXv_int3[0] ;
      if ( AV19diferenciaMeses < AV9VarFrecAct )
      {
         AV16actualizadaEsta = true ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&&opecliid ", "")+GXutil.trim( AV8OpeCliId)+httpContext.getMessage( " &ultiOpeCliVig", "")+GXutil.trim( localUtil.dtoc( AV18ultiOpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &fecha ", "")+GXutil.trim( localUtil.dtoc( AV20fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &diferenciaMeses ", "")+GXutil.trim( GXutil.str( AV19diferenciaMeses, 4, 0))+httpContext.getMessage( " &actualizadaEsta ", "")+GXutil.trim( GXutil.booltostr( AV16actualizadaEsta))+httpContext.getMessage( " &VarFrecAct ", "")+GXutil.trim( GXutil.str( AV9VarFrecAct, 2, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = variableactualizada.this.AV16actualizadaEsta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21vaciaFecha = GXutil.nullDate() ;
      AV18ultiOpeCliVig = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_int2 = new byte[1] ;
      GXv_int3 = new short[1] ;
      AV24Pgmname = "" ;
      AV24Pgmname = "variableActualizada" ;
      /* GeneXus formulas. */
      AV24Pgmname = "variableActualizada" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9VarFrecAct ;
   private byte GXv_int2[] ;
   private short AV19diferenciaMeses ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8OpeCliId ;
   private String AV24Pgmname ;
   private java.util.Date AV17parm_UltiOpeCliVig ;
   private java.util.Date AV20fecha ;
   private java.util.Date AV21vaciaFecha ;
   private java.util.Date AV18ultiOpeCliVig ;
   private java.util.Date GXv_date1[] ;
   private boolean AV16actualizadaEsta ;
   private boolean[] aP4 ;
}

