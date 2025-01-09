package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem extends GxUserType
{
   public SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem( )
   {
      this(  new ModelContext(SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem.class));
   }

   public SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem( ModelContext context )
   {
      super( context, "SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem");
   }

   public SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem");
   }

   public SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem( StructSdtK2BMultiLevelMenu_K2BMultiLevelMenuItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Code") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImageUrl") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImageClass") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Items") )
            {
               if ( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items == null )
               {
                  gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items = new GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>(web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem.class, "K2BMultiLevelMenuItem", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items.readxml(oReader, "Items") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Items") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowInExtraSmall") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowInSmall") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowInMedium") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowInLarge") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImageUrlIcono") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImageSVG") )
            {
               gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg = oReader.getValue() ;
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
         sName = "K2BMultiLevelMenu.K2BMultiLevelMenuItem" ;
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
      oWriter.writeElement("Code", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Title", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImageUrl", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImageClass", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Link", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items != null )
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
         gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items.writexml(oWriter, "Items", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("ShowInExtraSmall", GXutil.booltostr( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ShowInSmall", GXutil.booltostr( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ShowInMedium", GXutil.booltostr( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ShowInLarge", GXutil.booltostr( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImageUrlIcono", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImageSVG", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("Code", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code, false, false);
      AddObjectProperty("Title", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title, false, false);
      AddObjectProperty("ImageUrl", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl, false, false);
      AddObjectProperty("ImageClass", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass, false, false);
      AddObjectProperty("Link", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link, false, false);
      if ( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items != null )
      {
         AddObjectProperty("Items", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items, false, false);
      }
      AddObjectProperty("ShowInExtraSmall", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall, false, false);
      AddObjectProperty("ShowInSmall", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall, false, false);
      AddObjectProperty("ShowInMedium", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium, false, false);
      AddObjectProperty("ShowInLarge", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge, false, false);
      AddObjectProperty("ImageUrlIcono", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono, false, false);
      AddObjectProperty("ImageSVG", gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg, false, false);
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code = value ;
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title = value ;
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl = value ;
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass = value ;
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link = value ;
   }

   public GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items( )
   {
      if ( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items == null )
      {
         gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items = new GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>(web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem.class, "K2BMultiLevelMenuItem", "PayDay", remoteHandle);
      }
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items( GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items = value ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_SetNull( )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N = (byte)(1) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items = null ;
   }

   public boolean getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_IsNull( )
   {
      if ( gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N ;
   }

   public boolean getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall( boolean value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall = value ;
   }

   public boolean getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall( boolean value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall = value ;
   }

   public boolean getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium( boolean value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium = value ;
   }

   public boolean getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge( boolean value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge = value ;
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono = value ;
   }

   public String getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg ;
   }

   public void setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg( String value )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(0) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code = "" ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N = (byte)(1) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title = "" ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl = "" ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass = "" ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link = "" ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N = (byte)(1) ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono = "" ;
      gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N ;
   }

   public web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem Clone( )
   {
      return (web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)(clone()) ;
   }

   public void setStruct( web.StructSdtK2BMultiLevelMenu_K2BMultiLevelMenuItem struct )
   {
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code(struct.getCode());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title(struct.getTitle());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl(struct.getImageurl());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass(struct.getImageclass());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link(struct.getLink());
      GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux = new GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>(web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem.class, "K2BMultiLevelMenuItem", "PayDay", remoteHandle);
      Vector<web.StructSdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux1 = struct.getItems();
      if (gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux1.size(); i++)
         {
            gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux.add(new web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem(gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items(gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux);
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall(struct.getShowinextrasmall());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall(struct.getShowinsmall());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium(struct.getShowinmedium());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge(struct.getShowinlarge());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono(struct.getImageurlicono());
      setgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg(struct.getImagesvg());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtK2BMultiLevelMenu_K2BMultiLevelMenuItem getStruct( )
   {
      web.StructSdtK2BMultiLevelMenu_K2BMultiLevelMenuItem struct = new web.StructSdtK2BMultiLevelMenu_K2BMultiLevelMenuItem ();
      struct.setCode(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code());
      struct.setTitle(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title());
      struct.setImageurl(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl());
      struct.setImageclass(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass());
      struct.setLink(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link());
      struct.setItems(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().getStruct());
      struct.setShowinextrasmall(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall());
      struct.setShowinsmall(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall());
      struct.setShowinmedium(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium());
      struct.setShowinlarge(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge());
      struct.setImageurlicono(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono());
      struct.setImagesvg(getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg());
      return struct ;
   }

   protected byte gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_N ;
   protected byte gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Code ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageclass ;
   protected String sTagName ;
   protected boolean gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinextrasmall ;
   protected boolean gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinsmall ;
   protected boolean gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinmedium ;
   protected boolean gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Showinlarge ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurlicono ;
   protected String gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imagesvg ;
   protected GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items_aux ;
   protected GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> gxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items=null ;
}

