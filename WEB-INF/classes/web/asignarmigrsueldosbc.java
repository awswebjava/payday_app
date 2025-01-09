package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class asignarmigrsueldosbc extends GXProcedure
{
   public asignarmigrsueldosbc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( asignarmigrsueldosbc.class ), "" );
   }

   public asignarmigrsueldosbc( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( web.Sdtimportacion_legajo[] aP0 ,
                        String aP1 ,
                        java.util.Date aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( web.Sdtimportacion_legajo[] aP0 ,
                             String aP1 ,
                             java.util.Date aP2 )
   {
      asignarmigrsueldosbc.this.AV11importacion_legajo = aP0[0];
      this.aP0 = aP0;
      asignarmigrsueldosbc.this.AV9ImpLiqDetImp = aP1;
      asignarmigrsueldosbc.this.AV8fecha = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV9ImpLiqDetImp)==0) )
      {
         AV14migracion_sueldos.clear();
         if ( ! (GXutil.strcmp("", AV11importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrsueldos())==0) )
         {
            AV14migracion_sueldos.fromJSonString(AV11importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrsueldos(), null);
         }
         AV15migrSueldosItem = (web.Sdtmigracion_sueldos_migracion_sueldosItem)new web.Sdtmigracion_sueldos_migracion_sueldosItem(remoteHandle, context);
         AV15migrSueldosItem.setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha( AV8fecha );
         if ( GXutil.strSearch( AV9ImpLiqDetImp, ",", 1) == 0 )
         {
            GXt_decimal1 = DecimalUtil.ZERO ;
            GXv_decimal2[0] = GXt_decimal1 ;
            new web.planoadecimales(remoteHandle, context).execute( AV9ImpLiqDetImp, GXv_decimal2) ;
            asignarmigrsueldosbc.this.GXt_decimal1 = GXv_decimal2[0] ;
            AV15migrSueldosItem.setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo( GXt_decimal1 );
         }
         else
         {
            AV15migrSueldosItem.setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo( CommonUtil.decimalVal( AV9ImpLiqDetImp, ".") );
         }
         AV14migracion_sueldos.add(AV15migrSueldosItem, 0);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV21Pgmname, httpContext.getMessage( "antes &migracion_sueldos ", "")+AV14migracion_sueldos.toJSonString(false)) ;
         if ( AV14migracion_sueldos.size() > 1 )
         {
            AV16i = (short)(1) ;
            AV14migracion_sueldos.sort(httpContext.getMessage( "fecha,(sueldo)", ""));
            AV17ultFecha = GXutil.nullDate() ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV21Pgmname, httpContext.getMessage( "&migracion_sueldos ", "")+GXutil.trim( GXutil.str( AV14migracion_sueldos.size(), 9, 0))) ;
            while ( AV16i <= AV14migracion_sueldos.size() )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV21Pgmname, httpContext.getMessage( "&migracion_sueldos.Item(&i).fecha ", "")+GXutil.trim( localUtil.dtoc( ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV14migracion_sueldos.elementAt(-1+AV16i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ultFecha ", "")+GXutil.trim( localUtil.dtoc( AV17ultFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " sueldo ", "")+GXutil.str( ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV14migracion_sueldos.elementAt(-1+AV16i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo(), 14, 2)) ;
               if ( GXutil.dateCompare(GXutil.resetTime(((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV14migracion_sueldos.elementAt(-1+AV16i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha()), GXutil.resetTime(AV17ultFecha)) )
               {
                  AV14migracion_sueldos.removeItem(AV16i);
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV21Pgmname, httpContext.getMessage( "remove", "")) ;
               }
               else
               {
                  AV17ultFecha = ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV14migracion_sueldos.elementAt(-1+AV16i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha() ;
                  AV16i = (short)(AV16i+1) ;
               }
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV21Pgmname, httpContext.getMessage( "despues &migracion_sueldos ", "")+AV14migracion_sueldos.toJSonString(false)) ;
         AV11importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrsueldos( AV14migracion_sueldos.toJSonString(false) );
         AV11importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrperiodo( AV8fecha );
      }
      else
      {
         AV11importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrsueldos( "" );
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV21Pgmname, httpContext.getMessage( "borra", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = asignarmigrsueldosbc.this.AV11importacion_legajo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14migracion_sueldos = new GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem>(web.Sdtmigracion_sueldos_migracion_sueldosItem.class, "migracion_sueldosItem", "PayDay", remoteHandle);
      AV15migrSueldosItem = new web.Sdtmigracion_sueldos_migracion_sueldosItem(remoteHandle, context);
      GXt_decimal1 = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV21Pgmname = "" ;
      AV17ultFecha = GXutil.nullDate() ;
      AV21Pgmname = "asignarMigrSueldosBC" ;
      /* GeneXus formulas. */
      AV21Pgmname = "asignarMigrSueldosBC" ;
      Gx_err = (short)(0) ;
   }

   private short AV16i ;
   private short Gx_err ;
   private int AV18CliCod ;
   private java.math.BigDecimal GXt_decimal1 ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV9ImpLiqDetImp ;
   private String AV21Pgmname ;
   private java.util.Date AV8fecha ;
   private java.util.Date AV17ultFecha ;
   private web.Sdtimportacion_legajo[] aP0 ;
   private GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem> AV14migracion_sueldos ;
   private web.Sdtimportacion_legajo AV11importacion_legajo ;
   private web.Sdtmigracion_sueldos_migracion_sueldosItem AV15migrSueldosItem ;
}

