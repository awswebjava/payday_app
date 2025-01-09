package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtloc_sdt_Localidades extends GxUserType
{
   public Sdtloc_sdt_Localidades( )
   {
      this(  new ModelContext(Sdtloc_sdt_Localidades.class));
   }

   public Sdtloc_sdt_Localidades( ModelContext context )
   {
      super( context, "Sdtloc_sdt_Localidades");
   }

   public Sdtloc_sdt_Localidades( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtloc_sdt_Localidades");
   }

   public Sdtloc_sdt_Localidades( StructSdtloc_sdt_Localidades struct )
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
               if ( gxTv_Sdtloc_sdt_Localidades_Item == null )
               {
                  gxTv_Sdtloc_sdt_Localidades_Item = new web.Sdtloc_sdt_Localidades_Item(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtloc_sdt_Localidades_Item.readxml(oReader, "Item") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "loc_sdt.Localidades" ;
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
      if ( gxTv_Sdtloc_sdt_Localidades_Item != null )
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
         gxTv_Sdtloc_sdt_Localidades_Item.writexml(oWriter, "Item", sNameSpace1);
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
      if ( gxTv_Sdtloc_sdt_Localidades_Item != null )
      {
         AddObjectProperty("Item", gxTv_Sdtloc_sdt_Localidades_Item, false, false);
      }
   }

   public web.Sdtloc_sdt_Localidades_Item getgxTv_Sdtloc_sdt_Localidades_Item( )
   {
      if ( gxTv_Sdtloc_sdt_Localidades_Item == null )
      {
         gxTv_Sdtloc_sdt_Localidades_Item = new web.Sdtloc_sdt_Localidades_Item(remoteHandle, context);
      }
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_N = (byte)(0) ;
      return gxTv_Sdtloc_sdt_Localidades_Item ;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item( web.Sdtloc_sdt_Localidades_Item value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item = value;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item_SetNull( )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(1) ;
      gxTv_Sdtloc_sdt_Localidades_Item = (web.Sdtloc_sdt_Localidades_Item)null;
   }

   public boolean getgxTv_Sdtloc_sdt_Localidades_Item_IsNull( )
   {
      if ( gxTv_Sdtloc_sdt_Localidades_Item == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtloc_sdt_Localidades_Item_N( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(1) ;
      gxTv_Sdtloc_sdt_Localidades_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtloc_sdt_Localidades_N ;
   }

   public web.Sdtloc_sdt_Localidades Clone( )
   {
      return (web.Sdtloc_sdt_Localidades)(clone()) ;
   }

   public void setStruct( web.StructSdtloc_sdt_Localidades struct )
   {
      setgxTv_Sdtloc_sdt_Localidades_Item(new web.Sdtloc_sdt_Localidades_Item(struct.getItem()));
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtloc_sdt_Localidades getStruct( )
   {
      web.StructSdtloc_sdt_Localidades struct = new web.StructSdtloc_sdt_Localidades ();
      struct.setItem(getgxTv_Sdtloc_sdt_Localidades_Item().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtloc_sdt_Localidades_Item_N ;
   protected byte gxTv_Sdtloc_sdt_Localidades_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected web.Sdtloc_sdt_Localidades_Item gxTv_Sdtloc_sdt_Localidades_Item=null ;
}

