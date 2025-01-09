package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabarpuestosafipdesdejson extends GXProcedure
{
   public grabarpuestosafipdesdejson( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabarpuestosafipdesdejson.class ), "" );
   }

   public grabarpuestosafipdesdejson( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "hola", "")) ;
      GXv_char1[0] = AV11json ;
      GXv_char2[0] = AV12error ;
      new web.json_desdearchivo(remoteHandle, context).execute( AV10fecha, httpContext.getMessage( "puestosAFIP", ""), GXv_char1, GXv_char2) ;
      grabarpuestosafipdesdejson.this.AV11json = GXv_char1[0] ;
      grabarpuestosafipdesdejson.this.AV12error = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV12error)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV12error)) ;
      }
      else
      {
         AV8sdt_PuestoAfip.fromJSonString(AV11json, null);
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&&sdt_PuestoAfip ", "")+GXutil.trim( GXutil.str( AV8sdt_PuestoAfip.size(), 9, 0))) ;
         AV17GXV1 = 1 ;
         while ( AV17GXV1 <= AV8sdt_PuestoAfip.size() )
         {
            AV9item = (web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem)((web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem)AV8sdt_PuestoAfip.elementAt(-1+AV17GXV1));
            if ( GXutil.strSearch( GXutil.upper( AV9item.getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes()), httpContext.getMessage( "PROGRAMADOR", ""), 1) != 0 )
            {
               AV13PueAfipGenDes = httpContext.getMessage( "Programador", "") ;
            }
            else
            {
               AV13PueAfipGenDes = "" ;
            }
            new web.newpuestoafip(remoteHandle, context).execute( AV9item.getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod(), AV9item.getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes(), AV13PueAfipGenDes) ;
            AV17GXV1 = (int)(AV17GXV1+1) ;
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
      AV16Pgmname = "" ;
      AV10fecha = GXutil.nullDate() ;
      AV11json = "" ;
      GXv_char1 = new String[1] ;
      AV12error = "" ;
      GXv_char2 = new String[1] ;
      AV8sdt_PuestoAfip = new GXBaseCollection<web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem>(web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem.class, "sdt_PuestoAfipItem", "PayDay", remoteHandle);
      AV9item = new web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem(remoteHandle, context);
      AV13PueAfipGenDes = "" ;
      AV16Pgmname = "grabarPuestosAfipDesdeJSON" ;
      /* GeneXus formulas. */
      AV16Pgmname = "grabarPuestosAfipDesdeJSON" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17GXV1 ;
   private String AV16Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV10fecha ;
   private String AV11json ;
   private String AV12error ;
   private String AV13PueAfipGenDes ;
   private GXBaseCollection<web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem> AV8sdt_PuestoAfip ;
   private web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem AV9item ;
}

