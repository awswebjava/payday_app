package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class add_modprom extends GXProcedure
{
   public add_modprom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( add_modprom.class ), "" );
   }

   public add_modprom( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> executeUdp( String aP0 ,
                                                                           String aP1 )
   {
      add_modprom.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>[] aP2 )
   {
      add_modprom.this.AV10MprCod = aP0;
      add_modprom.this.AV11MprDescrip = aP1;
      add_modprom.this.AV8sdt_modprom = aP2[0];
      this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9item = (web.Sdtsdt_modprom_sdt_modpromItem)new web.Sdtsdt_modprom_sdt_modpromItem(remoteHandle, context);
      AV9item.setgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod( AV10MprCod );
      AV9item.setgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip( AV11MprDescrip );
      AV8sdt_modprom.add(AV9item, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = add_modprom.this.AV8sdt_modprom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9item = new web.Sdtsdt_modprom_sdt_modpromItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10MprCod ;
   private String AV11MprDescrip ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>[] aP2 ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> AV8sdt_modprom ;
   private web.Sdtsdt_modprom_sdt_modpromItem AV9item ;
}

