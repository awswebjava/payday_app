package web ;
import com.genexus.*;

public final  class StructSdtbanco_sdt_banco_sdtItem implements Cloneable, java.io.Serializable
{
   public StructSdtbanco_sdt_banco_sdtItem( )
   {
      this( -1, new ModelContext( StructSdtbanco_sdt_banco_sdtItem.class ));
   }

   public StructSdtbanco_sdt_banco_sdtItem( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod = "" ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip = "" ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getBancod( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod ;
   }

   public void setBancod( String value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod = value ;
   }

   public String getBandescrip( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip ;
   }

   public void setBandescrip( String value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip = value ;
   }

   public boolean getBanhabilitado( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado ;
   }

   public void setBanhabilitado( boolean value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado = value ;
   }

   public String getBancuit( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit ;
   }

   public void setBancuit( String value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit = value ;
   }

   protected byte gxTv_Sdtbanco_sdt_banco_sdtItem_N ;
   protected String gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod ;
   protected String gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit ;
   protected boolean gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado ;
   protected String gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip ;
}

