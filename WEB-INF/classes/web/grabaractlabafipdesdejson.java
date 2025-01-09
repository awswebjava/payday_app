package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaractlabafipdesdejson extends GXProcedure
{
   public grabaractlabafipdesdejson( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaractlabafipdesdejson.class ), "" );
   }

   public grabaractlabafipdesdejson( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      grabaractlabafipdesdejson.this.AV14PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "hola paicod ", "")+GXutil.trim( GXutil.str( AV14PaiCod, 4, 0))) ;
      GXv_char1[0] = AV11json ;
      GXv_char2[0] = AV12error ;
      new web.json_desdearchivo(remoteHandle, context).execute( AV10fecha, httpContext.getMessage( "actividadLaboralClasificada", ""), GXv_char1, GXv_char2) ;
      grabaractlabafipdesdejson.this.AV11json = GXv_char1[0] ;
      grabaractlabafipdesdejson.this.AV12error = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV12error)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV12error)) ;
      }
      else
      {
         AV13sdt_ActLabClasif.fromJSonString(AV11json, null);
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&&&sdt_ActLabClasif ", "")+GXutil.trim( GXutil.str( AV13sdt_ActLabClasif.size(), 9, 0))) ;
         AV20GXV1 = 1 ;
         while ( AV20GXV1 <= AV13sdt_ActLabClasif.size() )
         {
            AV9item = (web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem)((web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem)AV13sdt_ActLabClasif.elementAt(-1+AV20GXV1));
            if ( ( GXutil.strSearch( GXutil.upper( AV9item.getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip()), httpContext.getMessage( "INFORMÁTICA", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV9item.getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip()), httpContext.getMessage( "INFORMATICA", ""), 1) != 0 ) )
            {
               AV16ActLabAreaGen = httpContext.getMessage( "Sistemas", "") ;
            }
            else
            {
               if ( ( GXutil.strSearch( GXutil.upper( AV9item.getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip()), httpContext.getMessage( "CONSTRUCCION", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV9item.getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip()), httpContext.getMessage( "CONSTRUCCION", ""), 1) != 0 ) )
               {
                  AV16ActLabAreaGen = httpContext.getMessage( "Construcción y operaciones", "") ;
               }
               else
               {
                  AV16ActLabAreaGen = "" ;
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "paicod ", "")+GXutil.trim( GXutil.str( AV14PaiCod, 4, 0))) ;
            new web.newactlabclasif(remoteHandle, context).execute( AV14PaiCod, AV9item.getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro(), GXutil.trim( AV9item.getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip()), AV16ActLabAreaGen) ;
            AV20GXV1 = (int)(AV20GXV1+1) ;
         }
      }
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
      AV19Pgmname = "" ;
      AV10fecha = GXutil.nullDate() ;
      AV11json = "" ;
      GXv_char1 = new String[1] ;
      AV12error = "" ;
      GXv_char2 = new String[1] ;
      AV13sdt_ActLabClasif = new GXBaseCollection<web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem>(web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem.class, "sdt_ActLabClasifItem", "PayDay", remoteHandle);
      AV9item = new web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem(remoteHandle, context);
      AV16ActLabAreaGen = "" ;
      AV19Pgmname = "grabarActLabAfipDesdeJSON" ;
      /* GeneXus formulas. */
      AV19Pgmname = "grabarActLabAfipDesdeJSON" ;
      Gx_err = (short)(0) ;
   }

   private short AV14PaiCod ;
   private short Gx_err ;
   private int AV20GXV1 ;
   private String AV19Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV10fecha ;
   private String AV11json ;
   private String AV12error ;
   private String AV16ActLabAreaGen ;
   private GXBaseCollection<web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem> AV13sdt_ActLabClasif ;
   private web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem AV9item ;
}

