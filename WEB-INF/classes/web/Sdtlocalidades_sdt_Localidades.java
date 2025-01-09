package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtlocalidades_sdt_Localidades extends GxUserType
{
   public Sdtlocalidades_sdt_Localidades( )
   {
      this(  new ModelContext(Sdtlocalidades_sdt_Localidades.class));
   }

   public Sdtlocalidades_sdt_Localidades( ModelContext context )
   {
      super( context, "Sdtlocalidades_sdt_Localidades");
   }

   public Sdtlocalidades_sdt_Localidades( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtlocalidades_sdt_Localidades");
   }

   public Sdtlocalidades_sdt_Localidades( StructSdtlocalidades_sdt_Localidades struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "Item") )
            {
               if ( gxTv_Sdtlocalidades_sdt_Localidades_Item == null )
               {
                  gxTv_Sdtlocalidades_sdt_Localidades_Item = new GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem>(web.Sdtlocalidades_sdt_Localidades_ItemItem.class, "localidades_sdt.Localidades.ItemItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtlocalidades_sdt_Localidades_Item.readxmlcollection(oReader, "Item", "ItemItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Item") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "localidades_sdt.Localidades" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      if ( gxTv_Sdtlocalidades_sdt_Localidades_Item != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtlocalidades_sdt_Localidades_Item.writexmlcollection(oWriter, "Item", sNameSpace1, "ItemItem", sNameSpace1);
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      if ( gxTv_Sdtlocalidades_sdt_Localidades_Item != null )
      {
         AddObjectProperty("Item", gxTv_Sdtlocalidades_sdt_Localidades_Item, false, false);
      }
   }

   public GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem> getgxTv_Sdtlocalidades_sdt_Localidades_Item( )
   {
      if ( gxTv_Sdtlocalidades_sdt_Localidades_Item == null )
      {
         gxTv_Sdtlocalidades_sdt_Localidades_Item = new GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem>(web.Sdtlocalidades_sdt_Localidades_ItemItem.class, "localidades_sdt.Localidades.ItemItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtlocalidades_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(0) ;
      return gxTv_Sdtlocalidades_sdt_Localidades_Item ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_Item( GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem> value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_Item = value ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_Item_SetNull( )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_Item_N = (byte)(1) ;
      gxTv_Sdtlocalidades_sdt_Localidades_Item = null ;
   }

   public boolean getgxTv_Sdtlocalidades_sdt_Localidades_Item_IsNull( )
   {
      if ( gxTv_Sdtlocalidades_sdt_Localidades_Item == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtlocalidades_sdt_Localidades_Item_N( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_Item_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_Item_N = (byte)(1) ;
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_N ;
   }

   public web.Sdtlocalidades_sdt_Localidades Clone( )
   {
      return (web.Sdtlocalidades_sdt_Localidades)(clone()) ;
   }

   public void setStruct( web.StructSdtlocalidades_sdt_Localidades struct )
   {
      GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem> gxTv_Sdtlocalidades_sdt_Localidades_Item_aux = new GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem>(web.Sdtlocalidades_sdt_Localidades_ItemItem.class, "localidades_sdt.Localidades.ItemItem", "PayDay", remoteHandle);
      Vector<web.StructSdtlocalidades_sdt_Localidades_ItemItem> gxTv_Sdtlocalidades_sdt_Localidades_Item_aux1 = struct.getItem();
      if (gxTv_Sdtlocalidades_sdt_Localidades_Item_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtlocalidades_sdt_Localidades_Item_aux1.size(); i++)
         {
            gxTv_Sdtlocalidades_sdt_Localidades_Item_aux.add(new web.Sdtlocalidades_sdt_Localidades_ItemItem(gxTv_Sdtlocalidades_sdt_Localidades_Item_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtlocalidades_sdt_Localidades_Item(gxTv_Sdtlocalidades_sdt_Localidades_Item_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtlocalidades_sdt_Localidades getStruct( )
   {
      web.StructSdtlocalidades_sdt_Localidades struct = new web.StructSdtlocalidades_sdt_Localidades ();
      struct.setItem(getgxTv_Sdtlocalidades_sdt_Localidades_Item().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtlocalidades_sdt_Localidades_Item_N ;
   protected byte gxTv_Sdtlocalidades_sdt_Localidades_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem> gxTv_Sdtlocalidades_sdt_Localidades_Item_aux ;
   protected GXBaseCollection<web.Sdtlocalidades_sdt_Localidades_ItemItem> gxTv_Sdtlocalidades_sdt_Localidades_Item=null ;
}

