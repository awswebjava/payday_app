package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class add_banco extends GXProcedure
{
   public add_banco( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( add_banco.class ), "" );
   }

   public add_banco( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> executeUdp( String aP0 ,
                                                                       String aP1 )
   {
      add_banco.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>[] aP2 )
   {
      add_banco.this.AV10BanCod = aP0;
      add_banco.this.AV11BanDescrip = aP1;
      add_banco.this.AV8banco_sdt = aP2[0];
      this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9item = (web.Sdtbanco_sdt_banco_sdtItem)new web.Sdtbanco_sdt_banco_sdtItem(remoteHandle, context);
      AV9item.setgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod( AV10BanCod );
      AV9item.setgxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip( AV11BanDescrip );
      AV8banco_sdt.add(AV9item, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = add_banco.this.AV8banco_sdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9item = new web.Sdtbanco_sdt_banco_sdtItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10BanCod ;
   private String AV11BanDescrip ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>[] aP2 ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> AV8banco_sdt ;
   private web.Sdtbanco_sdt_banco_sdtItem AV9item ;
}

