package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_mot_egr_sdt_mot_egrItem extends GxUserType
{
   public Sdtsdt_mot_egr_sdt_mot_egrItem( )
   {
      this(  new ModelContext(Sdtsdt_mot_egr_sdt_mot_egrItem.class));
   }

   public Sdtsdt_mot_egr_sdt_mot_egrItem( ModelContext context )
   {
      super( context, "Sdtsdt_mot_egr_sdt_mot_egrItem");
   }

   public Sdtsdt_mot_egr_sdt_mot_egrItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_mot_egr_sdt_mot_egrItem");
   }

   public Sdtsdt_mot_egr_sdt_mot_egrItem( StructSdtsdt_mot_egr_sdt_mot_egrItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegCodigo") )
            {
               gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegSec") )
            {
               gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_mot_egr.sdt_mot_egrItem" ;
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
      oWriter.writeElement("MegCodigo", gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegSec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
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
      AddObjectProperty("MegCodigo", gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo, false, false);
      AddObjectProperty("ConMegSec", gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec, false, false);
   }

   public String getgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo( )
   {
      return gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo ;
   }

   public void setgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo( String value )
   {
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo = value ;
   }

   public short getgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec( )
   {
      return gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec ;
   }

   public void setgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec( short value )
   {
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo = "" ;
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N ;
   }

   public web.Sdtsdt_mot_egr_sdt_mot_egrItem Clone( )
   {
      return (web.Sdtsdt_mot_egr_sdt_mot_egrItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_mot_egr_sdt_mot_egrItem struct )
   {
      setgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo(struct.getMegcodigo());
      setgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec(struct.getConmegsec());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_mot_egr_sdt_mot_egrItem getStruct( )
   {
      web.StructSdtsdt_mot_egr_sdt_mot_egrItem struct = new web.StructSdtsdt_mot_egr_sdt_mot_egrItem ();
      struct.setMegcodigo(getgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo());
      struct.setConmegsec(getgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N ;
   protected short gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

