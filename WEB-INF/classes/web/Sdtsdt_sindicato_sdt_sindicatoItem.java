package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_sindicato_sdt_sindicatoItem extends GxUserType
{
   public Sdtsdt_sindicato_sdt_sindicatoItem( )
   {
      this(  new ModelContext(Sdtsdt_sindicato_sdt_sindicatoItem.class));
   }

   public Sdtsdt_sindicato_sdt_sindicatoItem( ModelContext context )
   {
      super( context, "Sdtsdt_sindicato_sdt_sindicatoItem");
   }

   public Sdtsdt_sindicato_sdt_sindicatoItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_sindicato_sdt_sindicatoItem");
   }

   public Sdtsdt_sindicato_sdt_sindicatoItem( StructSdtsdt_sindicato_sdt_sindicatoItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinCod") )
            {
               gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinDescrip") )
            {
               gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip = oReader.getValue() ;
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
         sName = "sdt_sindicato.sdt_sindicatoItem" ;
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
      oWriter.writeElement("SinCod", gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SinDescrip", gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip);
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
      AddObjectProperty("SinCod", gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod, false, false);
      AddObjectProperty("SinDescrip", gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip, false, false);
   }

   public String getgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod( )
   {
      return gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod ;
   }

   public void setgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod( String value )
   {
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod = value ;
   }

   public String getgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip( )
   {
      return gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip ;
   }

   public void setgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip( String value )
   {
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod = "" ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N = (byte)(1) ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N ;
   }

   public web.Sdtsdt_sindicato_sdt_sindicatoItem Clone( )
   {
      return (web.Sdtsdt_sindicato_sdt_sindicatoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_sindicato_sdt_sindicatoItem struct )
   {
      setgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod(struct.getSincod());
      setgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip(struct.getSindescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_sindicato_sdt_sindicatoItem getStruct( )
   {
      web.StructSdtsdt_sindicato_sdt_sindicatoItem struct = new web.StructSdtsdt_sindicato_sdt_sindicatoItem ();
      struct.setSincod(getgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod());
      struct.setSindescrip(getgxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip ;
}

