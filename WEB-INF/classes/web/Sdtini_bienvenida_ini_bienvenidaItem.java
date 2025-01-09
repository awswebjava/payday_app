package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtini_bienvenida_ini_bienvenidaItem extends GxUserType
{
   public Sdtini_bienvenida_ini_bienvenidaItem( )
   {
      this(  new ModelContext(Sdtini_bienvenida_ini_bienvenidaItem.class));
   }

   public Sdtini_bienvenida_ini_bienvenidaItem( ModelContext context )
   {
      super( context, "Sdtini_bienvenida_ini_bienvenidaItem");
   }

   public Sdtini_bienvenida_ini_bienvenidaItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtini_bienvenida_ini_bienvenidaItem");
   }

   public Sdtini_bienvenida_ini_bienvenidaItem( StructSdtini_bienvenida_ini_bienvenidaItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemId") )
            {
               gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MItemBienTextDef") )
            {
               gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MItemBienTitDef") )
            {
               gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef = oReader.getValue() ;
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
         sName = "ini_bienvenida.ini_bienvenidaItem" ;
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
      oWriter.writeElement("MenuItemId", gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MItemBienTextDef", gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MItemBienTitDef", gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef);
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
      AddObjectProperty("MenuItemId", gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid, false, false);
      AddObjectProperty("MItemBienTextDef", gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef, false, false);
      AddObjectProperty("MItemBienTitDef", gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef, false, false);
   }

   public String getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid ;
   }

   public void setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( String value )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(0) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid = value ;
   }

   public String getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef ;
   }

   public void setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( String value )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(0) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef = value ;
   }

   public String getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef ;
   }

   public void setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( String value )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(0) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid = "" ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(1) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef = "" ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N ;
   }

   public web.Sdtini_bienvenida_ini_bienvenidaItem Clone( )
   {
      return (web.Sdtini_bienvenida_ini_bienvenidaItem)(clone()) ;
   }

   public void setStruct( web.StructSdtini_bienvenida_ini_bienvenidaItem struct )
   {
      setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid(struct.getMenuitemid());
      setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef(struct.getMitembientextdef());
      setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef(struct.getMitembientitdef());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtini_bienvenida_ini_bienvenidaItem getStruct( )
   {
      web.StructSdtini_bienvenida_ini_bienvenidaItem struct = new web.StructSdtini_bienvenida_ini_bienvenidaItem ();
      struct.setMenuitemid(getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid());
      struct.setMitembientextdef(getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef());
      struct.setMitembientitdef(getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef());
      return struct ;
   }

   protected byte gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef ;
   protected String gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid ;
   protected String gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef ;
}

